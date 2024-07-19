package mx.ebc

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmployeeController {

    EmployeeService employeeService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        params.each { log.info "${it}" }
        respond employeeService.list(params), model:[employeeJJCount: employeeService.count()]
    }

    def show(Long id) {
        respond employeeService.get(id)
    }

    def create() {
        respond new Employee(params)
    }

    def save(Employee employeeJJ) {
        params.each { log.info "${it}" }
        if (employeeJJ == null) {
            notFound()
            return
        }

        try {
            employeeService.save(employeeJJ)
        } catch (ValidationException e) {
            respond employeeJJ.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: ["${employeeJJ.name} ${employeeJJ.lastName}", employeeJJ.id])
                // flash.message = "Empleado '${employeeJJ.name} ${employeeJJ.lastName}' Creado con éxito!!!!"
                redirect employeeJJ
            }
            '*' { respond employeeJJ, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond employeeService.get(id)
    }

    def update(Employee employeeJJ) {
        if (employeeJJ == null) {
            notFound()
            return
        }

        try {
            employeeService.save(employeeJJ)
        } catch (ValidationException e) {
            respond employeeJJ.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'employeeJJ.label', default: 'Employee'), employeeJJ.id])
                redirect employeeJJ
            }
            '*'{ respond employeeJJ, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        employeeService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'employeeJJ.label', default: 'Employee'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeJJ.label', default: 'Employee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
