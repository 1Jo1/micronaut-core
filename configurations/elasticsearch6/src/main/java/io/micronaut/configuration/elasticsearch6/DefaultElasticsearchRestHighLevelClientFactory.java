/*
 * Copyright 2017-2018 original authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.micronaut.configuration.elasticsearch6;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Requires;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;

/**
 * Default Factory for Create Elasticsearch6 RestHighLevelClient.
 *
 * @author lishuai
 * @since 1.0.1
 */
@Requires(beans = DefaultElasticsearchConfiguration.class)
@Factory
public class DefaultElasticsearchRestHighLevelClientFactory {

    /**
     * Create the {@link RestHighLevelClient} bean for the given configuration.
     *
     * @param elasticsearchRestClientConfiguration The {@link DefaultElasticsearchConfiguration} object
     * @return A {@link RestHighLevelClient} bean
     */
    @Bean(preDestroy = "close")
    RestHighLevelClient restHighLevelClient(DefaultElasticsearchConfiguration elasticsearchRestClientConfiguration) {
        return new RestHighLevelClient(RestClient.builder(elasticsearchRestClientConfiguration.toHttpHosts()));
    }
}