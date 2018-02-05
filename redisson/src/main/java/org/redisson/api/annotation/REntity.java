/**
 * Copyright 2016 Nikita Koksharov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.redisson.api.annotation;

import org.redisson.liveobject.resolver.NamingScheme;
import org.redisson.liveobject.resolver.DefaultNamingScheme;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.redisson.client.codec.Codec;
import org.redisson.codec.JsonJacksonCodec;

/**
 * Specifies that the class is a Live Object. 
 *
 * @author Rui Gu (https://github.com/jackygurui)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface REntity {

    public enum TransformationMode {
        
        IMPLEMENTATION_BASED, 
        
        ANNOTATION_BASED
    }
    
    /**
     * (Optional) Live Object naming scheme. Defines how to assign key names for each instance of this class. 
     * Used to create a reference to an existing Live Object and materialising a new one in redis. 
     * Defaults to {@link DefaultNamingScheme} implementation.
     * 
     * @return value
     */
    Class<? extends NamingScheme> namingScheme() default DefaultNamingScheme.class;

    /**
     * (Optional) Live Object state codec. Defaults to {@link JsonJacksonCodec}.
     * 
     * @return value
     */
    Class<? extends Codec> codec() default JsonJacksonCodec.class;

    /**
     * (Optional) Live Object field transformation. 
     * Defaults to {@link TransformationMode#ANNOTATION_BASED}
     * 
     * @return value
     */
    TransformationMode fieldTransformation() default TransformationMode.ANNOTATION_BASED;
    
}
