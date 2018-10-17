// Import Libraries
import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';
// Import Services
import { AutoService } from '../../services/auto.service';
// Import Models
import { Auto } from '../../domain/auto-motor_db/auto';
import { Persona } from '../../domain/auto-motor_db/persona';

// START - USED SERVICES
/**
* AutoService.create
*	@description CRUD ACTION create
*
* AutoService.get
*	@description CRUD ACTION get
*	@param ObjectId id Id 
*
* AutoService.update
*	@description CRUD ACTION update
*	@param ObjectId id Id
*
*/
// END - USED SERVICES

/**
 * This component allows to edit a Auto
 */
@Component({
    selector: 'app-auto-edit',
    templateUrl: 'auto-edit.component.html',
    styleUrls: ['auto-edit.component.css']
})
export class AutoEditComponent implements OnInit {
    item: Auto;
    listFK_PEROSNA_AUTO: Auto[];
    externalPersona: Persona[];
    model: Auto;
    formValid: Boolean;

    constructor(
    private autoService: AutoService,
    private route: ActivatedRoute,
    private location: Location) {
        // Init item
        this.item = new Auto();
        this.externalPersona = [];
    }

    /**
     * Init
     */
    ngOnInit() {
        this.route.params.subscribe(param => {
            const id: string = param['id'];
            if (id !== 'new') {
                this.autoService.get(id).subscribe(item => this.item = item);
                this.personaService.findByFK_PEROSNA_AUTO(id).subscribe(list => this.externalPersona = list);
            }
            // Get relations
        });
    }


    /**
     * Save Auto
     *
     * @param {boolean} formValid Form validity check
     * @param Auto item Auto to save
     */
    save(formValid: boolean, item: Auto): void {
        this.formValid = formValid;
        if (formValid) {
            if (item._id) {
                this.autoService.update(item).subscribe(data => this.goBack());
            } else {
                this.autoService.create(item).subscribe(data => this.goBack());
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



