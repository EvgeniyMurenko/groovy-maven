package com.groovy.contact;

import lombok.Data;

@Data
public class ContactEntity {

    private Long code;

    private Long contactCode;

    private Short entityTypeCode;

    private Long entityRefId;

    private String entityRefKey;

    private Short extSystemCode;

    public ContactEntity(Long code, Long contactCode, Short entityTypeCode, Long entityRefId, String entityRefKey, Short extSystemCode) {
        this.code = code;
        this.contactCode = contactCode;
        this.entityTypeCode = entityTypeCode;
        this.entityRefId = entityRefId;
        this.entityRefKey = entityRefKey;
        this.extSystemCode = extSystemCode;
    }
}
