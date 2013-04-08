package projetjee

import org.springframework.dao.DataIntegrityViolationException

class InscriptionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [inscriptionInstanceList: Inscription.list(params), inscriptionInstanceTotal: Inscription.count()]
    }

    def create() {
        [inscriptionInstance: new Inscription(params)]
    }

    def save() {
        def inscriptionInstance = new Inscription(params)
        if (!inscriptionInstance.save(flush: true)) {
            render(view: "create", model: [inscriptionInstance: inscriptionInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'inscription.label', default: 'Inscription'), inscriptionInstance.id])
        redirect(action: "show", id: inscriptionInstance.id)
    }

    def show(Long id) {
        def inscriptionInstance = Inscription.get(id)
        if (!inscriptionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscription.label', default: 'Inscription'), id])
            redirect(action: "list")
            return
        }

        [inscriptionInstance: inscriptionInstance]
    }

    def edit(Long id) {
        def inscriptionInstance = Inscription.get(id)
        if (!inscriptionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscription.label', default: 'Inscription'), id])
            redirect(action: "list")
            return
        }

        [inscriptionInstance: inscriptionInstance]
    }

    def update(Long id, Long version) {
        def inscriptionInstance = Inscription.get(id)
        if (!inscriptionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscription.label', default: 'Inscription'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (inscriptionInstance.version > version) {
                inscriptionInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'inscription.label', default: 'Inscription')] as Object[],
                          "Another user has updated this Inscription while you were editing")
                render(view: "edit", model: [inscriptionInstance: inscriptionInstance])
                return
            }
        }

        inscriptionInstance.properties = params

        if (!inscriptionInstance.save(flush: true)) {
            render(view: "edit", model: [inscriptionInstance: inscriptionInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'inscription.label', default: 'Inscription'), inscriptionInstance.id])
        redirect(action: "show", id: inscriptionInstance.id)
    }

    def delete(Long id) {
        def inscriptionInstance = Inscription.get(id)
        if (!inscriptionInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'inscription.label', default: 'Inscription'), id])
            redirect(action: "list")
            return
        }

        try {
            inscriptionInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'inscription.label', default: 'Inscription'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'inscription.label', default: 'Inscription'), id])
            redirect(action: "show", id: id)
        }
    }
}
