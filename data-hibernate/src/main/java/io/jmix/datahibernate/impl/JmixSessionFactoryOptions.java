/*
 * Copyright 2020 Haulmont.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.jmix.datahibernate.impl;

import org.hibernate.Interceptor;
import org.hibernate.boot.spi.AbstractDelegatingSessionFactoryOptions;
import org.hibernate.boot.spi.SessionFactoryOptions;
import org.springframework.beans.factory.BeanFactory;

public class JmixSessionFactoryOptions
        extends AbstractDelegatingSessionFactoryOptions {

    private BeanFactory beanFactory;

    private Interceptor interceptor;

    public JmixSessionFactoryOptions(
            SessionFactoryOptions baseOptions,
            BeanFactory beanFactory) {
        super(baseOptions);
        this.beanFactory = beanFactory;
    }

    public JmixSessionFactoryOptions(SessionFactoryOptions delegate, BeanFactory beanFactory, Interceptor interceptor) {
        super(delegate);
        this.beanFactory = beanFactory;
        this.interceptor = interceptor;
    }

    @Override
    public Interceptor getInterceptor() {
        return interceptor;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}