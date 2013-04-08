package projetjee



import org.junit.*
import grails.test.mixin.*

@TestFor(InscriptionController)
@Mock(Inscription)
class InscriptionControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/inscription/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.inscriptionInstanceList.size() == 0
        assert model.inscriptionInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.inscriptionInstance != null
    }

    void testSave() {
        controller.save()

        assert model.inscriptionInstance != null
        assert view == '/inscription/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/inscription/show/1'
        assert controller.flash.message != null
        assert Inscription.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/inscription/list'

        populateValidParams(params)
        def inscription = new Inscription(params)

        assert inscription.save() != null

        params.id = inscription.id

        def model = controller.show()

        assert model.inscriptionInstance == inscription
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/inscription/list'

        populateValidParams(params)
        def inscription = new Inscription(params)

        assert inscription.save() != null

        params.id = inscription.id

        def model = controller.edit()

        assert model.inscriptionInstance == inscription
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/inscription/list'

        response.reset()

        populateValidParams(params)
        def inscription = new Inscription(params)

        assert inscription.save() != null

        // test invalid parameters in update
        params.id = inscription.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/inscription/edit"
        assert model.inscriptionInstance != null

        inscription.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/inscription/show/$inscription.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        inscription.clearErrors()

        populateValidParams(params)
        params.id = inscription.id
        params.version = -1
        controller.update()

        assert view == "/inscription/edit"
        assert model.inscriptionInstance != null
        assert model.inscriptionInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/inscription/list'

        response.reset()

        populateValidParams(params)
        def inscription = new Inscription(params)

        assert inscription.save() != null
        assert Inscription.count() == 1

        params.id = inscription.id

        controller.delete()

        assert Inscription.count() == 0
        assert Inscription.get(inscription.id) == null
        assert response.redirectedUrl == '/inscription/list'
    }
}
