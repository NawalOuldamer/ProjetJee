package projetjee.question



import org.junit.*
import grails.test.mixin.*

@TestFor(QuestioSimpleController)
@Mock(QuestioSimple)
class QuestioSimpleControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/questioSimple/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.questioSimpleInstanceList.size() == 0
        assert model.questioSimpleInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.questioSimpleInstance != null
    }

    void testSave() {
        controller.save()

        assert model.questioSimpleInstance != null
        assert view == '/questioSimple/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/questioSimple/show/1'
        assert controller.flash.message != null
        assert QuestioSimple.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/questioSimple/list'

        populateValidParams(params)
        def questioSimple = new QuestioSimple(params)

        assert questioSimple.save() != null

        params.id = questioSimple.id

        def model = controller.show()

        assert model.questioSimpleInstance == questioSimple
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/questioSimple/list'

        populateValidParams(params)
        def questioSimple = new QuestioSimple(params)

        assert questioSimple.save() != null

        params.id = questioSimple.id

        def model = controller.edit()

        assert model.questioSimpleInstance == questioSimple
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/questioSimple/list'

        response.reset()

        populateValidParams(params)
        def questioSimple = new QuestioSimple(params)

        assert questioSimple.save() != null

        // test invalid parameters in update
        params.id = questioSimple.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/questioSimple/edit"
        assert model.questioSimpleInstance != null

        questioSimple.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/questioSimple/show/$questioSimple.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        questioSimple.clearErrors()

        populateValidParams(params)
        params.id = questioSimple.id
        params.version = -1
        controller.update()

        assert view == "/questioSimple/edit"
        assert model.questioSimpleInstance != null
        assert model.questioSimpleInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/questioSimple/list'

        response.reset()

        populateValidParams(params)
        def questioSimple = new QuestioSimple(params)

        assert questioSimple.save() != null
        assert QuestioSimple.count() == 1

        params.id = questioSimple.id

        controller.delete()

        assert QuestioSimple.count() == 0
        assert QuestioSimple.get(questioSimple.id) == null
        assert response.redirectedUrl == '/questioSimple/list'
    }
}
