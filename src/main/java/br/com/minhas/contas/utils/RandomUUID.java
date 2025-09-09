package br.com.minhas.contas.utils;


import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomUUID {

    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

    public static <T> T uuidIfNone(T entity) {
        PropertyAccessor accessor = PropertyAccessorFactory.forDirectFieldAccess(entity);
        if (accessor.isWritableProperty("id")) {
            String id = (String) accessor.getPropertyValue("id");
            if (Strings.isEmpty(id)) {
                accessor.setPropertyValue("id", RandomUUID.uuid());
            }
        }
        return entity;
    }
}
