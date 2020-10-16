package com.hotline.helpers;

public enum EErrors {
    EMPTY_FIELD("Заповніть це поле"),
    WRONG_DATA_FORMAT("Поле не відповідає формату"),
    TYPE_EMAIL_OR_PHONE("Введіть email або номер телефону"),
    EMAIL_OR_PHONE_ALREADY_TAKEN("Вибачте, але такий email або номер телефону вже зайнятий"),
    PASSWORD_IS_TO_SHORT("Довжина поля не може бути менше 4 і більше 16 символів");

    private final String errors;

    EErrors(String errors) {
        this.errors = errors;
    }

    public String getError() {
        return errors;
    }
}
