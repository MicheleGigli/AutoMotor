import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
// Import Services
import { PersonaService } from '../../services/persona.service';
// Import Models
import { Persona } from '../../domain/auto-motor_db/persona';

// START - USED SERVICES
/**
* PersonaService.delete
*	@description CRUD ACTION delete
*	@param ObjectId id Id
*
* PersonaService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component shows a list of Persona
 * @class PersonaListComponent
 */
@Component({
    selector: 'app-persona-list',
    templateUrl: './persona-list.component.html',
    styleUrls: ['./persona-list.component.css']
})
export class PersonaListComponent implements OnInit {
    list: Persona[];
    search: any = {};
    idSelected: string;
    constructor(
        private personaService: PersonaService,
    ) { }

    /**
     * Init
     */
    ngOnInit(): void {
        this.personaService.list().subscribe(list => this.list = list);
    }

    /**
     * Select Persona to remove
     *
     * @param {string} id Id of the Persona to remove
     */
    selectId(id: string) {
        this.idSelected = id;
    }

    /**
     * Remove selected Persona
     */
    deleteItem() {
        this.personaService.remove(this.idSelected).subscribe(data => this.list = this.list.filter(el => el._id !== this.idSelected));
    }

}
