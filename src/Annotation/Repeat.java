package Annotation;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Repeat {
    int count() default 1;
}