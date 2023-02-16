class Check_module {
    fun check(studyGroup: StudyGroup): Boolean{
        if ((studyGroup.get_name().length>0) and (studyGroup.get_studentcount()>0) and (studyGroup.get_coordinates().get_x()<12) and (studyGroup.get_coordinates().get_y()>-982)and (studyGroup.get_admin().name.length>0) and (studyGroup.get_admin().get_weight()>0)){
            if (!(studyGroup.get_shouldBeExpelled()?.equals(0)!!) and !(studyGroup.get_averageMark()?.equals(0)!!) and (studyGroup.get_admin().get_location()!!.get_name()!!.length<642)){
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