package com.yeonghun.portfolio.admin.context.link.service

import com.yeonghun.portfolio.admin.context.link.form.LinkForm
import com.yeonghun.portfolio.admin.data.TableDTO
import com.yeonghun.portfolio.domain.entity.Link
import com.yeonghun.portfolio.domain.repository.LinkRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 *packageName    : com.yeonghun.portfolio.admin.context.achievement.service
 * fileName       : AdminAchievementViewService
 * author         : Yeong-Huns
 * date           : 2025-03-15
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2025-03-15        Yeong-Huns       최초 생성
 */
@Service
class AdminLinkService (
    private val linkRepository: LinkRepository
){
    fun getLinkTable(): TableDTO{
        val classInfo = Link::class
        val entities = linkRepository.findAll()
        return TableDTO.of(classInfo, entities)
    }


    @Transactional
    fun save(form: LinkForm) =
        form.toLink().let(linkRepository::save)

    @Transactional
    fun update(id: Long, form: LinkForm) =
        form.toLink(id).let(linkRepository::save)

}