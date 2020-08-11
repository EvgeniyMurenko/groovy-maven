package com.groovy.xWPFTable;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BillGeneratorConstants {
    public static final String RECEIPT_SPECIFICATION = "Рахунок- специфікація";
    public static final String BILLING_DATE = "Дата виставлення: ";
    public static final String SUPPLIER_KEY = "Постачальник: ";
    public static final String SUPPLIER_VALUE = "ТОВ \"САВ-ДІСТРИБЬЮШН\"";
    public static final String NUMBER_CHAR = "№ ";
    public static final String NUMBER_PREFIX = "РПИ-7597-";
    public static final String CUSTOMER = "Покупець: ";
    public static final String SPECIFICATION_CHAPTER = "1. Cпецифікація";
    public static final String SUPPLIER_ADDRESS_KEY = "Місце знаходження: ";
    public static final String SUPPLIER_ADDRESS_VALUE = "04119, м.Київ, вул. Дорогожицька, б. 1, поверх 6";
    public static final String OKPO_KEY = "Код ЄДРПОУ: ";
    public static final String OKPO_VALUE = "35625082";
    public static final String DELIVERY_BASIS_KEY = "2. Базис поставки: %s. Місце поставки: %s";
    public static final String DELIVERY_DATES_KEY = "3. Строк поставки: ";
    public static final String DELIVERY_DATES_VALUE = "не пізніше 7 календарних днів з дати повної оплати цього рахунку-специфікації, за умови оплати не пізніше 3 календарних днів за дати витсавлення. У призначенні платежу обов’язково зазначати номер та дату цього Рахунку-специфікації.";
    public static final String INVOICE_DETAILS_KEY = "4. Оплата загальної суми (загальної вартості) товару має здійснюватися за такими реквізитами: ";
    public static final String INVOICE_DETAILS_VALUE = "рахунок № UA693006140000026006500287518 у ПАТ \"КРЕДІ АГРІКОЛЬ БАНК\" МФО 300614";
    public static final String CONDITIONS_CHAPTER = "5.Шляхом оплати цього Рахунку-специфікації протягом 3 (трьох) календарних днів  з дати виставлення покупець узгоджує асортимент (номенклатуру), кількість та ціну товару, приєднується до Договору поставки в цілому та погоджується з усіма його умовами. Текст договору поставки розміщено в мережі Інтернет за адресою http://www.foxtrot.com.ua/";
    public static final String CONDITIONS_VIOLATIONS_CHAPTER = "6. Якщо оплату не буде здійснено протягом 3 (трьох) календарних днів з дати виставлення цього Рахунку-специфікації (рахуючи день виставлення), цей Рахунок-специфікація вважається скасованим, не підлягає оплаті, а Постачальник не буде зобов’язаним здійснювати поставку товару.";
    public static final String PPDV_KEY = "Св. ППДВ ";
    public static final String PPDV_VALUE = "№ 100293149";
    public static final String INN_KEY = "Інд.податковий номер: ";
    public static final String INN_VALUE = "356250826598";
    public static final String TELEPHONE_KEY = "Тел./факс: ";
    public static final String TELEPHONE_VALUE = "0444952147";
    public static final String SIGNATURE = "______________/____________/ м.п.";
    public static final String TOTAL_WITHOUT_PDV = "Всього, б/ПДВ:";
    public static final String TOTAL_PDV = "ПДВ:";
    public static final String TOTAL_WITH_PDV = "Загальна сума з ПДВ:";
    public static final String TOTAL_QUANTITY = "Загальна кількість";
    public static final String GOOD_NAME = "Назва товару";
    public static final String GOOD_UNIT_KEY = "Од.вим.";
    public static final String GOOD_UNIT_VALUE = "шт.";
    public static final String GOOD_QUANTITY = "Кількість в од. виміру";
    public static final String GOOD_PRICE = "Ціна за одиницю, без ПДВ. грн.";
    public static final String GOOD_PRICE_TOTAL = "Загальна вартість, без ПДВ. грн.";
    public static final String CUSTOMER_SIGNATURE = "Покупець: ";

    public static final int FONT_SIZE = 11;
    public static final BigInteger SPACING_BEFORE = BigInteger.ZERO;
    public static final BigInteger SPACING_AFTER = BigInteger.ZERO;
    public static final BigInteger SPACING_LINE = BigInteger.valueOf(240);

    public static final BigInteger SIDE_MARGINS = BigInteger.valueOf(720);

    public static final BigDecimal NDS = BigDecimal.valueOf(0.2);

    public static final String DOCX_MIME_TYPE = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String FOXTROT_EMAIL = "Groupclientsupportsumifoxtrot@foxtrot.ua";
    public static final String IMAGE_PATH = "templates";
    public static final String SIGNATURE_FILE = "Signature.jpeg";
    public static final String STAMP_FILE = "Stamp.jpeg";
    public static final String STAMP_AND_SIGNATURE = "signature-and-stamp.jpg";
    public static final String EMAIL_SUBJECT = "Рахунок-фактура";
}
