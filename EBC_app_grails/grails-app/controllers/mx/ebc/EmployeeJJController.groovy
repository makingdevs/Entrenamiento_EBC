package mx.ebc

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class EmployeeJJController {

    EmployeeJJService employeeJJService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
				log.debug params.max
        respond employeeJJService.list(params), model:[employeeJJCount: employeeJJService.count()]
    }

    def show(Long id) {
        respond employeeJJService.get(id)
    }

    def create() {
        respond new EmployeeJJ(params)
    }

    def save(EmployeeJJ employeeJJ) {
        if (employeeJJ == null) {
            notFound()
            return
        }

        try {
            employeeJJService.save(employeeJJ)
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
        respond employeeJJService.get(id)
    }

    def update(EmployeeJJ employeeJJ) {
        if (employeeJJ == null) {
            notFound()
            return
        }

        try {
            employeeJJService.save(employeeJJ)
        } catch (ValidationException e) {
            respond employeeJJ.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'employeeJJ.label', default: 'EmployeeJJ'), employeeJJ.id])
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

        employeeJJService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'employeeJJ.label', default: 'EmployeeJJ'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeJJ.label', default: 'EmployeeJJ'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
