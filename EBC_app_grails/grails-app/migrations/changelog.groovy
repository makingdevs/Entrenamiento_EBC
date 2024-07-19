databaseChangeLog = {

    //changeSet(author: "makingdevs (generated)", id: "1721410850237-1") {
    //    createSequence(incrementBy: "1", sequenceName: "hibernate_sequence", startValue: "1")
    //}

    changeSet(author: "makingdevs (generated)", id: "1721410850237-2") {
        createTable(tableName: "addressjj") {
            column(autoIncrement: "true", name: "id", type: "NUMBER(19, 0)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "addressjjPK")
            }

            column(name: "version", type: "NUMBER(19, 0)") {
                constraints(nullable: "false")
            }

            column(name: "external_number", type: "VARCHAR(255 CHAR)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "street", type: "VARCHAR(255 CHAR)") {
                constraints(nullable: "false")
            }

            column(name: "zip_code", type: "VARCHAR(255 CHAR)") {
                constraints(nullable: "false")
            }

            column(name: "employee_id", type: "NUMBER(19, 0)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "makingdevs (generated)", id: "1721410850237-3") {
        createTable(tableName: "employeejj") {
            column(autoIncrement: "true", name: "id", type: "NUMBER(19, 0)") {
                constraints(nullable: "false", primaryKey: "true", primaryKeyName: "employeejjPK")
            }

            column(name: "version", type: "NUMBER(19, 0)") {
                constraints(nullable: "false")
            }

            column(name: "date_created", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "last_updated", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "name", type: "VARCHAR(255 CHAR)") {
                constraints(nullable: "false")
            }

            column(name: "active", type: "NUMBER(1, 0)") {
                constraints(nullable: "false")
            }

            column(name: "born_date", type: "timestamp") {
                constraints(nullable: "false")
            }

            column(name: "last_name", type: "VARCHAR(255 CHAR)") {
                constraints(nullable: "false")
            }

            column(name: "weight", type: "NUMBER(10, 0)") {
                constraints(nullable: "false")
            }
        }
    }

    changeSet(author: "makingdevs (generated)", id: "1721410850237-4") {
        addForeignKeyConstraint(baseColumnNames: "employee_id", baseTableName: "addressjj", constraintName: "FK5drwtfgfk25trnb1xh6f7rvul", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "employeejj", validate: "true")
    }
}
