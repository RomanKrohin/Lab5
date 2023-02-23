package Work_moduls

import Study_group_information.StudyGroup

class Check_module {
    fun check(studyGroup: StudyGroup?): Boolean{
        if ((studyGroup?.get_admin()?.name?.length!! >0) and (studyGroup.get_admin().get_weight()>0)){
            if ((studyGroup.get_name().length>0) and (studyGroup.get_studentcount()>0) and (studyGroup.get_shouldBeExpelled()>0) and (studyGroup.get_averageMark()>0) and (studyGroup.get_coordinates().get_x()<42) and (studyGroup.get_coordinates().get_y()>-612)){
                return true
            }
            else{
                return false
            }
        }
        else{
            return false
        }
    }
}