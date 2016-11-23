package pl.pluta.bytebuddytest;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;

import static net.bytebuddy.matcher.ElementMatchers.namedIgnoreCase;

public class ToStringMethodTransformer implements AgentBuilder.Transformer {
    @Override
    public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader) {
        return builder.method(namedIgnoreCase("toString")).intercept(FixedValue.value(this.getClass().getCanonicalName()));
    }
}