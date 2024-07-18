package exercise;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List<String> validate(Object address) {
        List<String> notNullData = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Annotation annotation = field.getAnnotation(NotNull.class);
            if (annotation != null){
                try {
                    Object value = field.get(address);
                    if (value == null) {
                        notNullData.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notNullData;
    }


}
// END
