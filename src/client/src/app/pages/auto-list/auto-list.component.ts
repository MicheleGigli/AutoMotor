import { Component } from '@angular/core';
import { OnInit } from '@angular/core';
// Import Services
import { AutoService } from '../../services/auto.service';
// Import Models
import { Auto } from '../../domain/auto-motor_db/auto';

// START - USED SERVICES
/**
* AutoService.delete
*	@description CRUD ACTION delete
*	@param ObjectId id Id
*
* AutoService.list
*	@description CRUD ACTION list
*
*/
// END - USED SERVICES

/**
 * This component shows a list of Auto
 * @class AutoListComponent
 */
@Component({
    selector: 'app-auto-list',
    templateUrl: './auto-list.component.html',
    styleUrls: ['./auto-list.component.css']
})
export class AutoListComponent implements OnInit {
    list: Auto[];
    search: any = {};
    idSelected: string;
    constructor(
        private autoService: AutoService,
    ) { }

    /**
     * Init
     */
    ngOnInit(): void {
        this.autoService.list().subscribe(list => this.list = list);
    }

    /**
     * Select Auto to remove
     *
     * @param {string} id Id of the Auto to remove
     */
    selectId(id: string) {
        this.idSelected = id;
    }

    /**
     * Remove selected Auto
     */
    deleteItem() {
        this.autoService.remove(this.idSelected).subscribe(data => this.list = this.list.filter(el => el._id !== this.idSelected));
    }

}
