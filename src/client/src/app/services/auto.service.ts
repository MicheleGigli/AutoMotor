// DEPENDENCIES
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
// BASE SERVICE
import { AutoBaseService } from './base/auto.base.service';


// start documentation
/**
 * Custom APIs
 *
 */
// end documentation

/**
 * YOU CAN OVERRIDE HERE AutoBaseService
 */
@Injectable()
export class AutoService extends AutoBaseService {

    // CONSTRUCTOR
    constructor(
        http: HttpClient,
    ) {
        super(http);
    }

    /*
    Name: changePassword
    Description: Change password of user from admin
    Params:
        id: id of user
        passwordNew: new password in MD5
        passwordAdmin: admin password in MD5
    */
    changePassword(id: String, passwordNew: string, passwordAdmin: string): Observable<void> {
        return this.http
            .post<void>(this.contextUrl + '/' + id + '/changePassword', {
                passwordNew: passwordNew,
                passwordAdmin: passwordAdmin
            })
            .pipe(
                map(response => response)
            );
    }
}
