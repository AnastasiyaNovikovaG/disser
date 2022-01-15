package novikava.entity;

public class Converter {
    public static LogbookModel convert(LogbookEntity logbookEntity) {
        LogbookModel logbookModel = new LogbookModel();
        logbookModel.setId(logbookEntity.getId());
        logbookModel.setDate(logbookEntity.getDate());
        logbookModel.setSubject(logbookEntity.getSubjectByIdSubj().getSubject());
        logbookModel.setHours(logbookEntity.getHours());
        logbookModel.setTeacher(logbookEntity.getTeacherByIdTeach().getName() + ' ' + logbookEntity.getTeacherByIdTeach().getSurname());
        logbookModel.setSem(logbookEntity.getIdSem());
        logbookModel.setMonth(logbookEntity.getMonthsByMonthsId().getMonth());
        logbookModel.setDepartment(logbookEntity.getDepartmentByDepartmentId().getName());
        logbookModel.setType(logbookEntity.getTypeOfClassByIdType().getName());

        return logbookModel;
    }
    public static LogbookEntity covertToEntity (LogbookModel logbookModel){
        LogbookEntity logbookEntity=new LogbookEntity();
        logbookEntity.setId(logbookModel.getId());
        logbookEntity.setDate(logbookModel.getDate());
        return logbookEntity;
    }

}
