package common;

import com.github.javafaker.Faker;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommonData {

    static Faker faker = new Faker();

    public static final String EMAIL_ADDRESS = faker.internet().emailAddress();
    public static final String ORDER_REFERENCE = "123";
    public static final String MESSAGE = "sample message";
    public static final String SEARCH_TEXT = "blouse";
    public static final String FIRSTNAME = faker.name().firstName();
    public static final String LASTNAME = faker.name().lastName();
    public static final String PASSWORD = faker.internet().password();
    public static final String ADDRESS = faker.address().streetAddress();
    public static final String CITY = faker.address().city();
    public static final String ZIPCODE = "12345";
    public static final String MOBILEPHONE = "123456789";

}
