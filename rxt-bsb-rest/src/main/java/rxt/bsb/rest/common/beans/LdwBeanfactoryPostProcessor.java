package rxt.bsb.rest.common.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Component
public class LdwBeanfactoryPostProcessor  implements BeanFactoryPostProcessor {

    private final static Logger logger = LoggerFactory.getLogger(LdwBeanfactoryPostProcessor.class);
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String beanName  []  = beanFactory.getBeanDefinitionNames();
        logger.info(Arrays.asList(beanName).toString());

    }
}
