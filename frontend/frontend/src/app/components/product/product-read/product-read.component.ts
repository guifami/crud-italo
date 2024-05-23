import { Component, OnInit } from '@angular/core';
import { Medico } from '../medico.model';
import { MedicoService } from '../medico.service';

@Component({
  selector: 'app-product-read',
  templateUrl: './product-read.component.html',
  styleUrls: ['./product-read.component.css']
})
export class ProductReadComponent implements OnInit {

  medicos!: Medico[];
  displayedColumns = ['idMedico', 'idCrm', 'nome', 'limite', 'action']

  constructor(private medicoService: MedicoService) { }

  ngOnInit(): void {
    this.medicoService.read().subscribe(medicos => {
      this.medicos = medicos._embedded.medicoVOList;
    })
  }

}
