-- ----------------------------
-- Table structure for PJ_APP_INFO
-- ----------------------------
CREATE TABLE "PJ_APP_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "APP_NAME" VARCHAR2(255 CHAR) VISIBLE ,
  "CURRENT_SERVER" VARCHAR2(255 CHAR) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "PASSWORD" VARCHAR2(255 CHAR) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of "PJ_APP_INFO"
-- ----------------------------
INSERT INTO "PJ_APP_INFO" VALUES ('1', 'wuzhi-worker', '127.0.0.1:10010', NULL, NULL, '123456');

-- ----------------------------
-- Table structure for PJ_CONTAINER_INFO
-- ----------------------------
CREATE TABLE "PJ_CONTAINER_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "APP_ID" NUMBER(19) VISIBLE ,
  "CONTAINER_NAME" VARCHAR2(255 CHAR) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "LAST_DEPLOY_TIME" TIMESTAMP(6) VISIBLE ,
  "SOURCE_INFO" VARCHAR2(255 CHAR) VISIBLE ,
  "SOURCE_TYPE" NUMBER(10) VISIBLE ,
  "STATUS" NUMBER(10) VISIBLE ,
  "VERSION" VARCHAR2(255 CHAR) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_INSTANCE_INFO
-- ----------------------------
CREATE TABLE "PJ_INSTANCE_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "ACTUAL_TRIGGER_TIME" NUMBER(19) VISIBLE ,
  "APP_ID" NUMBER(19) VISIBLE ,
  "EXPECTED_TRIGGER_TIME" NUMBER(19) VISIBLE ,
  "FINISHED_TIME" NUMBER(19) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "INSTANCE_ID" NUMBER(19) VISIBLE ,
  "INSTANCE_PARAMS" CLOB VISIBLE ,
  "JOB_ID" NUMBER(19) VISIBLE ,
  "JOB_PARAMS" CLOB VISIBLE ,
  "LAST_REPORT_TIME" NUMBER(19) VISIBLE ,
  "RESULT" CLOB VISIBLE ,
  "RUNNING_TIMES" NUMBER(19) VISIBLE ,
  "STATUS" NUMBER(10) VISIBLE ,
  "TASK_TRACKER_ADDRESS" VARCHAR2(255 CHAR) VISIBLE ,
  "TYPE" NUMBER(10) VISIBLE ,
  "WF_INSTANCE_ID" NUMBER(19) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_JOB_INFO
-- ----------------------------
CREATE TABLE "PJ_JOB_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "ALARM_CONFIG" VARCHAR2(255 CHAR) VISIBLE ,
  "APP_ID" NUMBER(19) VISIBLE ,
  "CONCURRENCY" NUMBER(10) VISIBLE ,
  "DESIGNATED_WORKERS" VARCHAR2(255 CHAR) VISIBLE ,
  "DISPATCH_STRATEGY" NUMBER(10) VISIBLE ,
  "EXECUTE_TYPE" NUMBER(10) VISIBLE ,
  "EXTRA" VARCHAR2(255 CHAR) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "INSTANCE_RETRY_NUM" NUMBER(10) VISIBLE ,
  "INSTANCE_TIME_LIMIT" NUMBER(19) VISIBLE ,
  "JOB_DESCRIPTION" VARCHAR2(255 CHAR) VISIBLE ,
  "JOB_NAME" VARCHAR2(255 CHAR) VISIBLE ,
  "JOB_PARAMS" CLOB VISIBLE ,
  "LIFECYCLE" VARCHAR2(255 CHAR) VISIBLE ,
  "LOG_CONFIG" VARCHAR2(255 CHAR) VISIBLE ,
  "MAX_INSTANCE_NUM" NUMBER(10) VISIBLE ,
  "MAX_WORKER_COUNT" NUMBER(10) VISIBLE ,
  "MIN_CPU_CORES" FLOAT(126) VISIBLE NOT NULL ,
  "MIN_DISK_SPACE" FLOAT(126) VISIBLE NOT NULL ,
  "MIN_MEMORY_SPACE" FLOAT(126) VISIBLE NOT NULL ,
  "NEXT_TRIGGER_TIME" NUMBER(19) VISIBLE ,
  "NOTIFY_USER_IDS" VARCHAR2(255 CHAR) VISIBLE ,
  "PROCESSOR_INFO" VARCHAR2(255 CHAR) VISIBLE ,
  "PROCESSOR_TYPE" NUMBER(10) VISIBLE ,
  "STATUS" NUMBER(10) VISIBLE ,
  "TAG" VARCHAR2(255 CHAR) VISIBLE ,
  "TASK_RETRY_NUM" NUMBER(10) VISIBLE ,
  "TIME_EXPRESSION" VARCHAR2(255 CHAR) VISIBLE ,
  "TIME_EXPRESSION_TYPE" NUMBER(10) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of "PJ_JOB_INFO"
-- ----------------------------
INSERT INTO "PJ_JOB_INFO" VALUES ('1', '{"alertThreshold":0,"silenceWindowLen":0,"statisticWindowLen":0}', '1', '5', NULL, '2', '1', NULL, NULL, NULL, '1', '0', NULL, '单机处理器执行测试', NULL, '{}', '{"type":1}', '0', '0', '0.0000000000000000', '0.0000000000000000', '0.0000000000000000', NULL, NULL, 'org.dromara.job.processors.StandaloneProcessorDemo', '1', '2', NULL, '1', '30000', '3');
INSERT INTO "PJ_JOB_INFO" VALUES ('2', '{"alertThreshold":0,"silenceWindowLen":0,"statisticWindowLen":0}', '1', '5', NULL, '1', '2', NULL, NULL, NULL, '0', '0', NULL, '广播处理器测试', NULL, '{}', '{"type":1}', '0', '0', '0.0000000000000000', '0.0000000000000000', '0.0000000000000000', NULL, NULL, 'org.dromara.job.processors.BroadcastProcessorDemo', '1', '2', NULL, '1', '30000', '3');
INSERT INTO "PJ_JOB_INFO" VALUES ('3', '{"alertThreshold":0,"silenceWindowLen":0,"statisticWindowLen":0}', '1', '5', NULL, '1', '4', NULL, NULL, NULL, '0', '0', NULL, 'Map处理器测试', NULL, '{}', '{"type":1}', '0', '0', '0.0000000000000000', '0.0000000000000000', '0.0000000000000000', NULL, NULL, 'org.dromara.job.processors.MapProcessorDemo', '1', '2', NULL, '1', '1000', '3');
INSERT INTO "PJ_JOB_INFO" VALUES ('4', '{"alertThreshold":0,"silenceWindowLen":0,"statisticWindowLen":0}', '1', '5', NULL, '1', '3', NULL, NULL, NULL, '0', '0', NULL, 'MapReduce处理器测试', NULL, '{}', '{"type":1}', '0', '0', '0.0000000000000000', '0.0000000000000000', '0.0000000000000000', NULL, NULL, 'org.dromara.job.processors.MapReduceProcessorDemo', '1', '2', NULL, '1', '1000', '3');

-- ----------------------------
-- Table structure for PJ_OMS_LOCK
-- ----------------------------
CREATE TABLE "PJ_OMS_LOCK" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "LOCK_NAME" VARCHAR2(255 CHAR) VISIBLE ,
  "MAX_LOCK_TIME" NUMBER(19) VISIBLE ,
  "OWNERIP" VARCHAR2(255 CHAR) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_SERVER_INFO
-- ----------------------------
CREATE TABLE "PJ_SERVER_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "IP" VARCHAR2(255 CHAR) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_USER_INFO
-- ----------------------------
CREATE TABLE "PJ_USER_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "EMAIL" VARCHAR2(255 CHAR) VISIBLE ,
  "EXTRA" VARCHAR2(255 CHAR) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "PASSWORD" VARCHAR2(255 CHAR) VISIBLE ,
  "PHONE" VARCHAR2(255 CHAR) VISIBLE ,
  "USERNAME" VARCHAR2(255 CHAR) VISIBLE ,
  "WEB_HOOK" VARCHAR2(255 CHAR) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_WORKFLOW_INFO
-- ----------------------------
CREATE TABLE "PJ_WORKFLOW_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "APP_ID" NUMBER(19) VISIBLE ,
  "EXTRA" VARCHAR2(255 CHAR) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "LIFECYCLE" VARCHAR2(255 CHAR) VISIBLE ,
  "MAX_WF_INSTANCE_NUM" NUMBER(10) VISIBLE ,
  "NEXT_TRIGGER_TIME" NUMBER(19) VISIBLE ,
  "NOTIFY_USER_IDS" VARCHAR2(255 CHAR) VISIBLE ,
  "PEDAG" CLOB VISIBLE ,
  "STATUS" NUMBER(10) VISIBLE ,
  "TIME_EXPRESSION" VARCHAR2(255 CHAR) VISIBLE ,
  "TIME_EXPRESSION_TYPE" NUMBER(10) VISIBLE ,
  "WF_DESCRIPTION" VARCHAR2(255 CHAR) VISIBLE ,
  "WF_NAME" VARCHAR2(255 CHAR) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_WORKFLOW_INSTANCE_INFO
-- ----------------------------
CREATE TABLE "PJ_WORKFLOW_INSTANCE_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "ACTUAL_TRIGGER_TIME" NUMBER(19) VISIBLE ,
  "APP_ID" NUMBER(19) VISIBLE ,
  "DAG" CLOB VISIBLE ,
  "EXPECTED_TRIGGER_TIME" NUMBER(19) VISIBLE ,
  "FINISHED_TIME" NUMBER(19) VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE ,
  "PARENT_WF_INSTANCE_ID" NUMBER(19) VISIBLE ,
  "RESULT" CLOB VISIBLE ,
  "STATUS" NUMBER(10) VISIBLE ,
  "WF_CONTEXT" CLOB VISIBLE ,
  "WF_INIT_PARAMS" CLOB VISIBLE ,
  "WF_INSTANCE_ID" NUMBER(19) VISIBLE ,
  "WORKFLOW_ID" NUMBER(19) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Table structure for PJ_WORKFLOW_NODE_INFO
-- ----------------------------
CREATE TABLE "PJ_WORKFLOW_NODE_INFO" (
  "ID" NUMBER(19) VISIBLE NOT NULL ,
  "APP_ID" NUMBER(19) VISIBLE NOT NULL ,
  "ENABLE" NUMBER(1) VISIBLE NOT NULL ,
  "EXTRA" CLOB VISIBLE ,
  "GMT_CREATE" TIMESTAMP(6) VISIBLE NOT NULL ,
  "GMT_MODIFIED" TIMESTAMP(6) VISIBLE NOT NULL ,
  "JOB_ID" NUMBER(19) VISIBLE ,
  "NODE_NAME" VARCHAR2(255 CHAR) VISIBLE ,
  "NODE_PARAMS" CLOB VISIBLE ,
  "SKIP_WHEN_FAILED" NUMBER(1) VISIBLE NOT NULL ,
  "TYPE" NUMBER(10) VISIBLE ,
  "WORKFLOW_ID" NUMBER(19) VISIBLE
)
TABLESPACE "ROOT"
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Primary Key structure for table PJ_APP_INFO
-- ----------------------------
ALTER TABLE "PJ_APP_INFO" ADD CONSTRAINT "SYS_C0012204" PRIMARY KEY ("ID");

-- ----------------------------
-- Uniques structure for table PJ_APP_INFO
-- ----------------------------
ALTER TABLE "PJ_APP_INFO" ADD CONSTRAINT "UIDX01_APP_INFO" UNIQUE ("APP_NAME") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table PJ_APP_INFO
-- ----------------------------
ALTER TABLE "PJ_APP_INFO" ADD CONSTRAINT "SYS_C0012203" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table PJ_CONTAINER_INFO
-- ----------------------------
ALTER TABLE "PJ_CONTAINER_INFO" ADD CONSTRAINT "SYS_C0012206" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PJ_CONTAINER_INFO
-- ----------------------------
ALTER TABLE "PJ_CONTAINER_INFO" ADD CONSTRAINT "SYS_C0012205" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_CONTAINER_INFO
-- ----------------------------
CREATE INDEX "IDX01_CONTAINER_INFO"
  ON "PJ_CONTAINER_INFO" ("APP_ID" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_INSTANCE_INFO
-- ----------------------------
ALTER TABLE "PJ_INSTANCE_INFO" ADD CONSTRAINT "SYS_C0012208" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PJ_INSTANCE_INFO
-- ----------------------------
ALTER TABLE "PJ_INSTANCE_INFO" ADD CONSTRAINT "SYS_C0012207" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_INSTANCE_INFO
-- ----------------------------
CREATE INDEX "IDX01_INSTANCE_INFO"
  ON "PJ_INSTANCE_INFO" ("JOB_ID" ASC, "STATUS" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;
CREATE INDEX "IDX02_INSTANCE_INFO"
  ON "PJ_INSTANCE_INFO" ("APP_ID" ASC, "STATUS" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;
CREATE INDEX "IDX03_INSTANCE_INFO"
  ON "PJ_INSTANCE_INFO" ("INSTANCE_ID" ASC, "STATUS" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_JOB_INFO
-- ----------------------------
ALTER TABLE "PJ_JOB_INFO" ADD CONSTRAINT "SYS_C0012213" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PJ_JOB_INFO
-- ----------------------------
ALTER TABLE "PJ_JOB_INFO" ADD CONSTRAINT "SYS_C0012209" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_JOB_INFO" ADD CONSTRAINT "SYS_C0012210" CHECK ("MIN_CPU_CORES" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_JOB_INFO" ADD CONSTRAINT "SYS_C0012211" CHECK ("MIN_DISK_SPACE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_JOB_INFO" ADD CONSTRAINT "SYS_C0012212" CHECK ("MIN_MEMORY_SPACE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_JOB_INFO
-- ----------------------------
CREATE INDEX "IDX01_JOB_INFO"
  ON "PJ_JOB_INFO" ("APP_ID" ASC, "NEXT_TRIGGER_TIME" ASC, "TIME_EXPRESSION_TYPE" ASC, "STATUS" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_OMS_LOCK
-- ----------------------------
ALTER TABLE "PJ_OMS_LOCK" ADD CONSTRAINT "SYS_C0012215" PRIMARY KEY ("ID");

-- ----------------------------
-- Uniques structure for table PJ_OMS_LOCK
-- ----------------------------
ALTER TABLE "PJ_OMS_LOCK" ADD CONSTRAINT "UIDX01_OMS_LOCK" UNIQUE ("LOCK_NAME") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table PJ_OMS_LOCK
-- ----------------------------
ALTER TABLE "PJ_OMS_LOCK" ADD CONSTRAINT "SYS_C0012214" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Primary Key structure for table PJ_SERVER_INFO
-- ----------------------------
ALTER TABLE "PJ_SERVER_INFO" ADD CONSTRAINT "SYS_C0012217" PRIMARY KEY ("ID");

-- ----------------------------
-- Uniques structure for table PJ_SERVER_INFO
-- ----------------------------
ALTER TABLE "PJ_SERVER_INFO" ADD CONSTRAINT "UIDX01_SERVER_INFO" UNIQUE ("IP") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table PJ_SERVER_INFO
-- ----------------------------
ALTER TABLE "PJ_SERVER_INFO" ADD CONSTRAINT "SYS_C0012216" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_SERVER_INFO
-- ----------------------------
CREATE INDEX "IDX01_SERVER_INFO"
  ON "PJ_SERVER_INFO" ("GMT_MODIFIED" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_USER_INFO
-- ----------------------------
ALTER TABLE "PJ_USER_INFO" ADD CONSTRAINT "SYS_C0012219" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PJ_USER_INFO
-- ----------------------------
ALTER TABLE "PJ_USER_INFO" ADD CONSTRAINT "SYS_C0012218" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_USER_INFO
-- ----------------------------
CREATE INDEX "UIDX01_USER_INFO"
  ON "PJ_USER_INFO" ("USERNAME" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;
CREATE INDEX "UIDX02_USER_INFO"
  ON "PJ_USER_INFO" ("EMAIL" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_WORKFLOW_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_INFO" ADD CONSTRAINT "SYS_C0012221" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PJ_WORKFLOW_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_INFO" ADD CONSTRAINT "SYS_C0012220" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_WORKFLOW_INFO
-- ----------------------------
CREATE INDEX "IDX01_WORKFLOW_INFO"
  ON "PJ_WORKFLOW_INFO" ("APP_ID" ASC, "NEXT_TRIGGER_TIME" ASC, "TIME_EXPRESSION_TYPE" ASC, "STATUS" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_WORKFLOW_INSTANCE_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_INSTANCE_INFO" ADD CONSTRAINT "SYS_C0012223" PRIMARY KEY ("ID");

-- ----------------------------
-- Uniques structure for table PJ_WORKFLOW_INSTANCE_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_INSTANCE_INFO" ADD CONSTRAINT "UIDX01_WF_INSTANCE" UNIQUE ("WF_INSTANCE_ID") NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Checks structure for table PJ_WORKFLOW_INSTANCE_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_INSTANCE_INFO" ADD CONSTRAINT "SYS_C0012222" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_WORKFLOW_INSTANCE_INFO
-- ----------------------------
CREATE INDEX "IDX01_WF_INSTANCE"
  ON "PJ_WORKFLOW_INSTANCE_INFO" ("WORKFLOW_ID" ASC, "EXPECTED_TRIGGER_TIME" ASC, "APP_ID" ASC, "STATUS" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;

-- ----------------------------
-- Primary Key structure for table PJ_WORKFLOW_NODE_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012230" PRIMARY KEY ("ID");

-- ----------------------------
-- Checks structure for table PJ_WORKFLOW_NODE_INFO
-- ----------------------------
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012224" CHECK ("ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012225" CHECK ("APP_ID" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012226" CHECK ("ENABLE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012227" CHECK ("GMT_CREATE" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012228" CHECK ("GMT_MODIFIED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PJ_WORKFLOW_NODE_INFO" ADD CONSTRAINT "SYS_C0012229" CHECK ("SKIP_WHEN_FAILED" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;

-- ----------------------------
-- Indexes structure for table PJ_WORKFLOW_NODE_INFO
-- ----------------------------
CREATE INDEX "IDX01_WORKFLOW_NODE_INFO"
  ON "PJ_WORKFLOW_NODE_INFO" ("GMT_CREATE" ASC, "WORKFLOW_ID" ASC)
  LOGGING
  TABLESPACE "ROOT"
  VISIBLE
PCTFREE 10
INITRANS 2
STORAGE (
  INITIAL 65536
  NEXT 1048576
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
  FLASH_CACHE DEFAULT
)
   USABLE;
