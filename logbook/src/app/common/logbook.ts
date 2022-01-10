import {TypeOfClass} from "./typeOfClass";

export class Logbook{
  id : number;
  date : Date;
  idType : number;
  type: TypeOfClass;
  idSubj: number;
  hours : number;
  idTeach: number;
  idSem: number;
  monthsId: number;
  departmentId: number;
  /*private TypeOfClassEntity typeOfClassByIdType;
  private SubjectEntity subjectEntityByIdSubj;
  private TeacherEntity teacherEntityByIdTeach;
  private SemestrEntity semestrEntityByIdSem;
  private MonthsEntity monthsByMonthsEntityId;
  private DepartmentEntity departmentByDepartmentEntityId;*/
  constructor(){

  }
}
