package Commands

import Collections.ActionsWithCollection
import Collections.Collection
import Exceptions.CommandException
import StudyGroupInformation.StudyGroup
import WorkModuls.*

/**
 * Класс команды, которая добавляет объект по его ключу
 */
class CommandInsert(workCollection: Collection<String, StudyGroup>): Command(), ActionsWithCollection, CreateCheckModule, WorkWithAsker, WorkWithAnswer {
    var collection: Collection<String, StudyGroup>
    init {
        collection=workCollection
    }


    /**
     *  Метод работы команды
     *  @param collection
     *  @param key
     */
    override fun commandDo(key: String): Answer {
        try {
            val answer= createReversedAnswer()
            val asker= createAsker()
            val studyGroup= asker.askStudyGroup()
            val listOfId = mutableListOf<Long>(0)
            for (i in collection.collection.values){
                listOfId.add(i.getId())
            }
            studyGroup.setId(listOfId.max()+1)
            executeAdd(collection, studyGroup, key)
            return answer
        }
        catch (e: CommandException){
            return createAnswer()
        }
    }

    override fun executeAdd(collection: Collection<String, StudyGroup>, studyGroup: StudyGroup, key: String) {
        collection.add(studyGroup, key)
    }

    override fun executeRemove(collection: Collection<String, StudyGroup>, key: String) {
        collection.remove(key)
    }

    override fun createModule(): CheckModule {
        return CheckModule()
    }

    override fun createAsker(): Asker {
        return Asker()
    }

    override fun createAnswer(): Answer {
        return Answer(nameError = "Insert")
    }

    override fun createReversedAnswer(): Answer {
        return Answer(false)
    }

}