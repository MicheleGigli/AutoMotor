/**
 *
 *
  _____                      _              _ _ _     _   _     _        __ _ _
 |  __ \                    | |            | (_) |   | | | |   (_)      / _(_) |
 | |  | | ___    _ __   ___ | |_    ___  __| |_| |_  | |_| |__  _ ___  | |_ _| | ___
 | |  | |/ _ \  | '_ \ / _ \| __|  / _ \/ _` | | __| | __| '_ \| / __| |  _| | |/ _ \
 | |__| | (_) | | | | | (_) | |_  |  __/ (_| | | |_  | |_| | | | \__ \ | | | | |  __/
 |_____/ \___/  |_| |_|\___/ \__|  \___|\__,_|_|\__|  \__|_| |_|_|___/ |_| |_|_|\___|


 * DO NOT EDIT THIS FILE!!
 *
 *  TO CUSTOMIZE PersonaBase PLEASE EDIT ../persona.ts
 *
 *  -- THIS FILE WILL BE OVERWRITTEN ON THE NEXT SKAFFOLDER'S CODE GENERATION --
 *
 */
import { Auto } from '../auto';

/**
 * This is the model of Persona object
 *
 */
export class PersonaBase {

    constructor() { }

    public _id: string;
    public cognome: string;
    public eta?: number;
    public mail?: string;
    public nome: string;
    // Relations FK_PEROSNA_AUTO
    public FK_PEROSNA_AUTO: Auto | string;
}
