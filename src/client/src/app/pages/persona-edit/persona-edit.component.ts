// Import Libraries
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
// Import Services
import { PersonaService } from '../../services/persona.service';
import { AutoService } from '../../services/auto.service';
// Import Models
import { Persona } from '../../domain/auto-motor_db/persona';
import { Auto } from '../../domain/auto-motor_db/auto';

// START - USED SERVICES
/**
* PersonaService.create
*	@description CRUD ACTION create
*
* PersonaService.get
*	@description CRUD ACTION get
*	@param ObjectId id Id 
*
* AutoService.list
*	@description CRUD ACTION list
*
* PersonaService.update
*	@description CRUD ACTION update
*	@param ObjectId id Id
*
*/
// END - USED SERVICES

/**
 * This component allows to edit a Persona
 */
@Component({
    selector: 'app-persona-edit',
    templateUrl: 'persona-edit.component.html',
    styleUrls: ['persona-edit.component.css']
})
export class PersonaEditComponent implements OnInit {
    item: Persona;
    listFK_PEROSNA_AUTO: Auto[];
    model: Persona;
    formValid: Boolean;

    constructor(
    private personaService: PersonaService,
    private autoService: AutoService,
    private route: ActivatedRoute,
    private location: Location) {
        // Init item
        this.item = new Persona();
    }

    /**
     * Init
     */
    ngOnInit() {
        this.route.params.subscribe(param => {
            const id: string = param['id'];
            if (id !== 'new') {
                this.personaService.get(id).subscribe(item => this.item = item);
            }
            // Get relations
            this.autoService.list().subscribe(list => this.listFK_PEROSNA_AUTO = list);
        });
    }


    /**
     * Save Persona
     *
     * @param {boolean} formValid Form validity check
     * @param Persona item Persona to save
     */
    save(formValid: boolean, item: Persona): void {
        this.formValid = formValid;
        if (formValid) {
            if (item._id) {
                this.personaService.update(item).subscribe(data => this.goBack());
            } else {
                this.personaService.create(item).subscribe(data => this.goBack());
            } 
        }
    }

    /**
     * Go Back
     */
    goBack(): void {
        this.location.back();
    }


}



