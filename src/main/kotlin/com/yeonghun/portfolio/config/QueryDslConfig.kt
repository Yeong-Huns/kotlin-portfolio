package com.yeonghun.portfolio.config

import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 *packageName    : com.yeonghun.portfolio.config
 * fileName       : QueryDslConfig
 * author         : Yeong-Huns
 * date           : 2025-03-10
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-10        Yeong-Huns       최초 생성
 */
/* 쿼리 DSL 설정 */
@Configuration
class QueryDslConfig ( private val em: EntityManager ) {
    @Bean
    fun querydsl(): JPAQueryFactory = JPAQueryFactory(em)
}