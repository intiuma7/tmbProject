package annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.tmb.enums.CategoryTypes;

@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotation {

	public String[] author() default "admin";
	public CategoryTypes category() default CategoryTypes.FUNCTIONAL;
	
}
