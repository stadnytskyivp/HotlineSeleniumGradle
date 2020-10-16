package com.hotline.helpers;

public enum EErrors {
    EMPTY_FIELD("�������� �� ����"),
    WRONG_DATA_FORMAT("���� �� ������� �������"),
    TYPE_EMAIL_OR_PHONE("������ email ��� ����� ��������"),
    EMAIL_OR_PHONE_ALREADY_TAKEN("�������, ��� ����� email ��� ����� �������� ��� ��������"),
    PASSWORD_IS_TO_SHORT("������� ���� �� ���� ���� ����� 4 � ����� 16 �������"),
    NICKNAME_TAKEN("�������� �� ��� ��������.");

    private final String errors;

    EErrors(String errors) {
        this.errors = errors;
    }

    public String getError() {
        return errors;
    }
}
