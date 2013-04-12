package projetjee.question

import org.springframework.dao.DataIntegrityViolationException

class QuestioSimpleController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [questioSimpleInstanceList: QuestioSimple.list(params), questioSimpleInstanceTotal: QuestioSimple.count()]
    }

    def create() {
        [questioSimpleInstance: new QuestioSimple(params)]
    }

    def save() {
        def questioSimpleInstance = new QuestioSimple(params)
        if (!questioSimpleInstance.save(flush: true)) {
            render(view: "create", model: [questioSimpleInstance: questioSimpleInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), questioSimpleInstance.id])
        redirect(action: "show", id: questioSimpleInstance.id)
    }

    def show(Long id) {
        def questioSimpleInstance = QuestioSimple.get(id)
        if (!questioSimpleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), id])
            redirect(action: "list")
            return
        }

        [questioSimpleInstance: questioSimpleInstance]
    }

    def edit(Long id) {
        def questioSimpleInstance = QuestioSimple.get(id)
        if (!questioSimpleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), id])
            redirect(action: "list")
            return
        }

        [questioSimpleInstance: questioSimpleInstance]
    }

    def update(Long id, Long version) {
        def questioSimpleInstance = QuestioSimple.get(id)
        if (!questioSimpleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (questioSimpleInstance.version > version) {
                questioSimpleInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'questioSimple.label', default: 'QuestioSimple')] as Object[],
                          "Another user has updated this QuestioSimple while you were editing")
                render(view: "edit", model: [questioSimpleInstance: questioSimpleInstance])
                return
            }
        }

        questioSimpleInstance.properties = params

        if (!questioSimpleInstance.save(flush: true)) {
            render(view: "edit", model: [questioSimpleInstance: questioSimpleInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), questioSimpleInstance.id])
        redirect(action: "show", id: questioSimpleInstance.id)
    }

    def delete(Long id) {
        def questioSimpleInstance = QuestioSimple.get(id)
        if (!questioSimpleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), id])
            redirect(action: "list")
            return
        }

        try {
            questioSimpleInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'questioSimple.label', default: 'QuestioSimple'), id])
            redirect(action: "show", id: id)
        }
    }
}
