package AlgBlog.Others;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

public class AnnoRefle {
}


// Defiene an annotation
@Target(value = ElementType.METHOD)
@interface MyAnnotation {

}