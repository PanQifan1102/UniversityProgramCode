/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/12/6 9:04:53                            */
/*==============================================================*/


drop table if exists accident_dispose_table;

drop table if exists armarium_table;

drop table if exists complaint_dispose_table;

drop table if exists department_table;

drop table if exists disease_message_table;

drop table if exists doctor_table;

drop table if exists doctor_working_table;

drop table if exists emergency_diagnose_table;

drop table if exists emergency_disease_history_table;

drop table if exists examine_diagnose_table;

drop table if exists finance_table;

drop table if exists hospitalized_diagnose_table;

drop table if exists hospitalized_disease_history_table;

drop table if exists kinsfolk_message_table;

drop table if exists logistics_working_table;

drop table if exists medical_insurance_message_table;

drop table if exists medicine_table;

drop table if exists nurse_table;

drop table if exists ogistics_table;

drop table if exists outpatient_diagnose_table;

drop table if exists outpatient_disease_history_table;

drop table if exists past_medical_history_table;

drop table if exists patient_basic_message_table;

drop table if exists surgrey_message_table;

/*==============================================================*/
/* Table: accident_dispose_table                                */
/*==============================================================*/
create table accident_dispose_table
(
   accident_type        int not null,
   accident_title       char(20) not null,
   accident_message     char(200) not null,
   accident_group       char(50) not null,
   accident_result      char(100) not null,
   primary key (accident_type)
);

/*==============================================================*/
/* Table: armarium_table                                        */
/*==============================================================*/
create table armarium_table
(
   armarium_id          int not null,
   diagnose_id          int,
   armarium_name        char(20) not null,
   armarium_department  int not null,
   armarium_number      int not null,
   armarium_leader_id   int not null,
   armarium_buy_time    date not null,
   armarium_maintenance_record char(500) not null,
   primary key (armarium_id)
);

/*==============================================================*/
/* Table: complaint_dispose_table                               */
/*==============================================================*/
create table complaint_dispose_table
(
   complaint_id         int not null,
   complaint_title      char(20) not null,
   complaint_message    char(200) not null,
   complaint_department_id int not null,
   complaint_dispose_result char(100) not null,
   complaint_dispose_leader int not null,
   complaint_name       char(10),
   complaint_teltphone  char(11) not null,
   primary key (complaint_id)
);

/*==============================================================*/
/* Table: department_table                                      */
/*==============================================================*/
create table department_table
(
   department_id        int not null,
   doctor_id            int,
   nurse_id             int,
   armarium_id          int,
   complaint_id         int,
   department_name      char(10) not null,
   department_address   char(20) not null,
   department_leader_name char(10) not null,
   department_telephone int not null,
   department_message   char(100) not null,
   primary key (department_id)
);

/*==============================================================*/
/* Table: disease_message_table                                 */
/*==============================================================*/
create table disease_message_table
(
   disease_id           int not null,
   doctor_id            int,
   disease_name         char(20) not null,
   disease_logogram     char(20) not null,
   disease_message      char(100) not null,
   disease_type         char(5) not null,
   primary key (disease_id)
);

/*==============================================================*/
/* Table: doctor_table                                          */
/*==============================================================*/
create table doctor_table
(
   doctor_id            int not null,
   diagnose_id          int,
   doctor_name          char(10) not null,
   doctor_sex           char(1) not null,
   doctor_age           int not null,
   doctor_department    char(10) not null,
   doctor_grade         char(5) not null,
   doctor_telephone     int not null,
   doctor_message       char(100) not null,
   primary key (doctor_id)
);

/*==============================================================*/
/* Table: doctor_working_table                                  */
/*==============================================================*/
create table doctor_working_table
(
   doctor_id            int not null,
   doctor_working_time  date not null,
   doctor_working_department_id int not null,
   primary key (doctor_id)
);

/*==============================================================*/
/* Table: emergency_diagnose_table                              */
/*==============================================================*/
create table emergency_diagnose_table
(
   diagnose_id          int not null,
   in_emergency_time    date not null,
   in_doctor_id         int not null,
   simple_examine_diagnose char(50) not null,
   outpatient_dispose   char(100) not null,
   accept_department_id int not null,
   accept_doctor_id     int,
   primary key (diagnose_id)
);

/*==============================================================*/
/* Table: emergency_disease_history_table                       */
/*==============================================================*/
create table emergency_disease_history_table
(
   diagnose_id          int not null,
   sur_diagnose_id      int,
   primary key (diagnose_id)
);

/*==============================================================*/
/* Table: examine_diagnose_table                                */
/*==============================================================*/
create table examine_diagnose_table
(
   diagnose_id          int not null,
   medicine_id          int,
   examine_diagnose_message char(50) not null,
   doctor_id            int not null,
   department_id        int not null,
   examine_result       char(100) not null,
   primary key (diagnose_id)
);

/*==============================================================*/
/* Table: finance_table                                         */
/*==============================================================*/
create table finance_table
(
   income_sum           int not null,
   outcome_sun          int not null,
   surplus_sum          int not null,
   public_subsidy       int not null,
   othercost            int not null,
   finance_dispose_emplovee_id int not null,
   primary key (surplus_sum)
);

/*==============================================================*/
/* Table: hospitalized_diagnose_table                           */
/*==============================================================*/
create table hospitalized_diagnose_table
(
   diagnose_id          int not null,
   surplus_sum          int,
   doctor_id            int not null,
   nurse_id             int not null,
   hospitalized_department int not null,
   severity_grade       char(1) not null,
   in_hospitalized_time date not null,
   predict_out_hospitalized_time date not null,
   actual_out_hospitalized_time date not null,
   bed_number           int not null,
   hospitalized_case_history char(10000) not null,
   out_hospitalized_diagnose char(100) not null,
   out_hospitalized_price int not null,
   out_hospitalized_advice char(100) not null,
   primary key (diagnose_id)
);

/*==============================================================*/
/* Table: hospitalized_disease_history_table                    */
/*==============================================================*/
create table hospitalized_disease_history_table
(
   diagnose_id          int not null,
   sur_diagnose_id      int,
   exa_diagnose_id      int,
   nurse_id             int,
   eme_diagnose_id      int,
   medicine_id          int,
   primary key (diagnose_id)
);

/*==============================================================*/
/* Table: kinsfolk_message_table                                */
/*==============================================================*/
create table kinsfolk_message_table
(
   kinsfolk_id_number   int not null,
   patient__id_number   int,
   kinsfolk_name        char(10) not null,
   kinsfolk_sex         char(1) not null,
   kinsfolk_relation    char(5) not null,
   kinsfolk_birthday    date not null,
   kinsfolk_telephone   int not null,
   kinsfolk_address     char(30) not null,
   primary key (kinsfolk_id_number)
);

/*==============================================================*/
/* Table: logistics_working_table                               */
/*==============================================================*/
create table logistics_working_table
(
   logistics_emplovee_id int not null,
   logistics_working_time date not null,
   logistics_working_department_id int not null,
   primary key (logistics_emplovee_id)
);

/*==============================================================*/
/* Table: medical_insurance_message_table                       */
/*==============================================================*/
create table medical_insurance_message_table
(
   medical_insurance_type char(10) not null,
   patient__id_number   int,
   medical_insurance_address char(10) not null,
   medical_insurance_number char(20) not null,
   primary key (medical_insurance_type)
);

/*==============================================================*/
/* Table: medicine_table                                        */
/*==============================================================*/
create table medicine_table
(
   medicine_id          int not null,
   surplus_sum          int,
   medicine_name        char(20) not null,
   medicine_logogram    char(20) not null,
   medicine_classification char(10) not null,
   medicine_surplus_number int not null,
   medicine_price       int not null,
   medicine_loseefficacy_date date not null,
   medicine_use_way     char(100) not null,
   medicine_specificatio char(20) not null,
   medicine_manufacturers char(20) not null,
   primary key (medicine_id)
);

/*==============================================================*/
/* Table: nurse_table                                           */
/*==============================================================*/
create table nurse_table
(
   nurse_id             int not null,
   nurse_name           char(10) not null,
   nurse_sex            char(1) not null,
   nurse_department     char(10) not null,
   nurse_grade          char(5) not null,
   nurse_telephone      int not null,
   nurse_message        char(100) not null,
   nurse_age            int not null,
   primary key (nurse_id)
);

/*==============================================================*/
/* Table: ogistics_table                                        */
/*==============================================================*/
create table ogistics_table
(
   logistics_emplovee_id int not null,
   department_id        int,
   accident_type        int,
   surplus_sum          int,
   logistics_emplovee_name char(10) not null,
   logistics_emplovee_sex char(1) not null,
   logistics_deptartment int not null,
   logistics_emplovee_job char(10) not null,
   logistics_emplovee_telephone int not null,
   primary key (logistics_emplovee_id)
);

/*==============================================================*/
/* Table: outpatient_diagnose_table                             */
/*==============================================================*/
create table outpatient_diagnose_table
(
   diagnose_id          int not null,
   patinet_id_number    char(18) not null,
   diagnose_time        date not null,
   diagnose_department  int not null,
   diagnose_doctor_id   int not null,
   patinet_own_explain  char(50) not null,
   outpatient_examine_diagnose char(100) not null,
   outpatient_advice    char(100) not null,
   primary key (diagnose_id)
);

/*==============================================================*/
/* Table: outpatient_disease_history_table                      */
/*==============================================================*/
create table outpatient_disease_history_table
(
   medicine_id          int not null,
   doctor_id            int,
   diagnose_id          int,
   patient__id_number   int,
   primary key (medicine_id)
);

/*==============================================================*/
/* Table: past_medical_history_table                            */
/*==============================================================*/
create table past_medical_history_table
(
   see_doctors_hospital char(10) not null,
   patient__id_number   int,
   state_of_illness     char(50) not null,
   see_doctors_result   char(50) not null,
   primary key (see_doctors_hospital)
);

/*==============================================================*/
/* Table: patient_basic_message_table                           */
/*==============================================================*/
create table patient_basic_message_table
(
   patient__id_number   int not null,
   patient_name         char(10) not null,
   patient_sex          char(1) not null,
   patient_birthday     date not null,
   patient_address      char(30) not null,
   patient_telephone    char(11) not null,
   patient_allergy_message char(30),
   patient_blood_type   char(5) not null,
   primary key (patient__id_number)
);

/*==============================================================*/
/* Table: surgrey_message_table                                 */
/*==============================================================*/
create table surgrey_message_table
(
   diagnose_id          int not null,
   department_id        int not null,
   surgrey_name         char(50) not null,
   surgrey_time         date not null,
   surgrey_doctor_id    int not null,
   surgrey_nurse_id     int not null,
   surgrey_start_time   date not null,
   surgrey_end_time     date not null,
   surgrey_group        char(100) not null,
   surgrey_message      char(1000) not null,
   surgrey_result       char(500) not null,
   primary key (diagnose_id)
);

alter table armarium_table add constraint FK_Reference_17 foreign key (diagnose_id)
      references examine_diagnose_table (diagnose_id) on delete restrict on update restrict;

alter table department_table add constraint FK_Reference_1 foreign key (doctor_id)
      references doctor_table (doctor_id) on delete restrict on update restrict;

alter table department_table add constraint FK_Reference_2 foreign key (nurse_id)
      references nurse_table (nurse_id) on delete restrict on update restrict;

alter table department_table add constraint FK_Reference_3 foreign key (armarium_id)
      references armarium_table (armarium_id) on delete restrict on update restrict;

alter table department_table add constraint FK_Reference_4 foreign key (complaint_id)
      references complaint_dispose_table (complaint_id) on delete restrict on update restrict;

alter table disease_message_table add constraint FK_Reference_31 foreign key (doctor_id)
      references doctor_table (doctor_id) on delete restrict on update restrict;

alter table doctor_table add constraint FK_Reference_30 foreign key (diagnose_id)
      references emergency_disease_history_table (diagnose_id) on delete restrict on update restrict;

alter table doctor_table add constraint FK_Reference_5 foreign key (doctor_id)
      references doctor_working_table (doctor_id) on delete restrict on update restrict;

alter table emergency_disease_history_table add constraint FK_Reference_27 foreign key (diagnose_id)
      references emergency_diagnose_table (diagnose_id) on delete restrict on update restrict;

alter table emergency_disease_history_table add constraint FK_Reference_28 foreign key (sur_diagnose_id)
      references surgrey_message_table (diagnose_id) on delete restrict on update restrict;

alter table examine_diagnose_table add constraint FK_Reference_23 foreign key (medicine_id)
      references outpatient_disease_history_table (medicine_id) on delete restrict on update restrict;

alter table hospitalized_diagnose_table add constraint FK_Reference_26 foreign key (surplus_sum)
      references finance_table (surplus_sum) on delete restrict on update restrict;

alter table hospitalized_disease_history_table add constraint FK_Reference_20 foreign key (medicine_id)
      references outpatient_disease_history_table (medicine_id) on delete restrict on update restrict;

alter table hospitalized_disease_history_table add constraint FK_Reference_21 foreign key (diagnose_id)
      references hospitalized_diagnose_table (diagnose_id) on delete restrict on update restrict;

alter table hospitalized_disease_history_table add constraint FK_Reference_22 foreign key (sur_diagnose_id)
      references surgrey_message_table (diagnose_id) on delete restrict on update restrict;

alter table hospitalized_disease_history_table add constraint FK_Reference_24 foreign key (exa_diagnose_id)
      references examine_diagnose_table (diagnose_id) on delete restrict on update restrict;

alter table hospitalized_disease_history_table add constraint FK_Reference_25 foreign key (nurse_id)
      references nurse_table (nurse_id) on delete restrict on update restrict;

alter table hospitalized_disease_history_table add constraint FK_Reference_29 foreign key (eme_diagnose_id)
      references emergency_disease_history_table (diagnose_id) on delete restrict on update restrict;

alter table kinsfolk_message_table add constraint FK_Reference_16 foreign key (patient__id_number)
      references patient_basic_message_table (patient__id_number) on delete restrict on update restrict;

alter table medical_insurance_message_table add constraint FK_Reference_18 foreign key (patient__id_number)
      references patient_basic_message_table (patient__id_number) on delete restrict on update restrict;

alter table medicine_table add constraint FK_Reference_9 foreign key (surplus_sum)
      references finance_table (surplus_sum) on delete restrict on update restrict;

alter table ogistics_table add constraint FK_Reference_10 foreign key (surplus_sum)
      references finance_table (surplus_sum) on delete restrict on update restrict;

alter table ogistics_table add constraint FK_Reference_6 foreign key (department_id)
      references department_table (department_id) on delete restrict on update restrict;

alter table ogistics_table add constraint FK_Reference_7 foreign key (logistics_emplovee_id)
      references logistics_working_table (logistics_emplovee_id) on delete restrict on update restrict;

alter table ogistics_table add constraint FK_Reference_8 foreign key (accident_type)
      references accident_dispose_table (accident_type) on delete restrict on update restrict;

alter table outpatient_disease_history_table add constraint FK_Reference_11 foreign key (medicine_id)
      references medicine_table (medicine_id) on delete restrict on update restrict;

alter table outpatient_disease_history_table add constraint FK_Reference_12 foreign key (doctor_id)
      references doctor_working_table (doctor_id) on delete restrict on update restrict;

alter table outpatient_disease_history_table add constraint FK_Reference_13 foreign key (diagnose_id)
      references outpatient_diagnose_table (diagnose_id) on delete restrict on update restrict;

alter table outpatient_disease_history_table add constraint FK_Reference_15 foreign key (patient__id_number)
      references patient_basic_message_table (patient__id_number) on delete restrict on update restrict;

alter table past_medical_history_table add constraint FK_Reference_19 foreign key (patient__id_number)
      references patient_basic_message_table (patient__id_number) on delete restrict on update restrict;

