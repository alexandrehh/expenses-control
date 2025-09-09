package br.com.minhas.contas.services.item.impl;

import br.com.minhas.contas.dtos.category.CategoryDto;
import br.com.minhas.contas.dtos.item.ItemDto;
import br.com.minhas.contas.mappers.category.CategoryMapper;
import br.com.minhas.contas.mappers.item.ItemMapper;
import br.com.minhas.contas.mappers.month.MonthMapper;
import br.com.minhas.contas.models.category.CategoryModel;
import br.com.minhas.contas.models.item.ItemModel;
import br.com.minhas.contas.repositories.item.ItemRepository;
import br.com.minhas.contas.services.item.ItemService;
import br.com.minhas.contas.validations.category.CategoryValidation;
import br.com.minhas.contas.validations.item.ItemValidation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemValidation itemValidation;
    @Autowired
    private ItemMapper itemMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Autowired
    private MonthMapper monthMapper;
    @Autowired
    private CategoryValidation categoryValidation;

    @Override
    public List<ItemDto> saveUpdateItems(List<ItemDto> itemDtos, List<CategoryModel> categoryModels) {
        itemValidation.validateItemInfos(itemDtos);
        var itemModels = getItemModels(itemDtos, categoryModels);
        var newItemModels = itemRepository.saveAll(itemModels);
        return getItemDtos(newItemModels);
    }

    @Override
    public ItemDto getItem(String itemId) {
        return getItemDto(getItemModel(itemId));
    }

    @Override
    public List<ItemDto> getItems() {
        var itemModels = itemRepository.findAll();
        return itemModels.stream().map(this::getItemDto).collect(Collectors.toList());
    }

    @Override
    public List<ItemDto> getItemsByCategoryId(String categoryId) {
        var itemModels = itemRepository.findItemModelsByCategoryId(categoryId);
        return itemModels.stream().map(this::getItemDto).collect(Collectors.toList());
    }

    /**
     * Busca uma lista de entidades {@link ItemModel} que representam as infos dos itens
     * de uma categoria de um mês
     * @param itemDtos DTOs com as infos dos itens
     * @param categoryModels Entidades das categorias
     * @return Uma lista de entidades {@link ItemModel} com as infos dos itens de uma categoria de um mês
     */
    List<ItemModel> getItemModels(List<ItemDto> itemDtos, List<CategoryModel> categoryModels) {
       return itemDtos.stream().filter(Objects::nonNull)
               .map(itemDto -> {
                   var categoryModel = getCategoryModel(categoryModels, itemDto);
                   categoryValidation.validateCategoryModel(categoryModel);
                   return itemMapper.toItemModel(itemDto, categoryModel);
               })
               .collect(Collectors.toList());
    }

    /**
     * Busca uma lista de DTOs {@link ItemDto} que represetam as infos dos itens de uma
     * categoria de um mês salvos
     * @param itemModels Entidades dos itens de uma categoria de um mês
     * @return Uma lista de DTOs {@link ItemDto} com as infos salvas
     */
    List<ItemDto> getItemDtos(List<ItemModel> itemModels) {
       return itemModels.stream().filter(Objects::nonNull).map(this::getItemDto).collect(Collectors.toList());
    }

    /**
     * Busca um item
     * @param itemId Id do item
     * @return A entidade {@link ItemModel} com as infos do item
     */
    ItemModel getItemModel(String itemId) {
        var itemModel = itemRepository.findById(itemId).orElse(null);
        itemValidation.validateItemModel(itemModel);
        return itemModel;
    }

    /**
     * Cria um novo DTO {@link ItemDto} com as infos do item
     * @param itemModel Entidade do item
     * @return  DTO {@link ItemDto} com as infos do item
     */
    ItemDto getItemDto(ItemModel itemModel) {
        var categoryModel = Objects.nonNull(itemModel) ? itemModel.getCategory() : null;
        var monthModel = Objects.nonNull(categoryModel) ? categoryModel.getMonth() : null;
        var monthDto = monthMapper.toMonthDto(monthModel);
        var categoryDto = categoryMapper.toCategoryDto(categoryModel, monthDto);
        return itemMapper.toItemDto(itemModel, categoryDto);
    }

    /**
     * Busca a entidade {@link CategoryModel} com as infos da categoria do item
     * @param categoryModels Entidades das categorias
     * @param itemDto DTO com as infos do item
     * @return A entidade {@link CategoryModel} com as infos da categoria do item
     */
    CategoryModel getCategoryModel(List<CategoryModel> categoryModels, ItemDto itemDto) {
        if (Objects.isNull(itemDto) || Objects.isNull(itemDto.getCategory())) {
            return null;
        }

        return categoryModels.stream()
                .filter(categoryModel -> isValidCategory(categoryModel, itemDto))
                .findFirst().orElse(null);
    }

    /**
     * Valida se o nome da categoria é valido a partir da entidade {@link CategoryModel}
     * @param categoryModel Entidade da categoria
     * @return Verdadeiro; Se o nome não é nulo ou vazio; Falso; Se o nome é nulo ou vazio
     */
    Boolean isValidCategoryName(CategoryModel categoryModel) {
        return Objects.nonNull(categoryModel) && StringUtils.isNotEmpty(categoryModel.getName());
    }

    /**
     * Valida se o nome da categoria valido a partir do DTO {@link ItemDto}
     * @param categoryDto DTO da categoria informada no DTO {@link ItemDto}
     * @return Verdadeiro; Se o nome não é nulo ou vazio; Falso; Se o nome é nulo ou vazio
     */
    Boolean isValidCategoryNameByItemDto(CategoryDto categoryDto) {
        return Objects.nonNull(categoryDto) && StringUtils.isNotEmpty(categoryDto.getName());
    }

    /**
     * Verifica se o nome da categoria é igual entre a entidade da categoria e o nome informado via request
     * @param categoryModel Entidade da categoria
     * @param itemDto DTO com as infos do item
     * @return Verdadeiro; Se o nome é igual entre a categoria da entidade e categoria informada via request;
     * Falso; Se o nome não é igual entre a categoria da entidade e categoria informada via request
     */
    Boolean isValidCategory(CategoryModel categoryModel, ItemDto itemDto) {
        return isValidCategoryName(categoryModel) &&
                isValidCategoryNameByItemDto(itemDto.getCategory()) &&
                categoryModel.getName().equals(itemDto.getCategory().getName());
    }
}
