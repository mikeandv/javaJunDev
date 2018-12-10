package lessons.lesson_19.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//описание
//@Target() - отвечает за то к чему будет применена аннотация, если не укащана может быть применена чему угодно
//METHOD, CONSTRUCTOR, FIELD
//@Retention() - указывает когда будет использоваться аннотация
//например
//@Retention(RetentionPolicy.RUNTIME)
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PermissionRequired {
    User.Permission value();
    //могут возвращать String, enum, примитивы и аннотации



}
