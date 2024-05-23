import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Medico } from '../medico.model';
import { MedicoService } from '../medico.service';

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {

  medico: Medico = {
    idMedico: 0,
    idCrm: 0,
    limite: 0,
    nome: ''
  }

  constructor(private medicoService: MedicoService, private router: Router) { }

  ngOnInit(): void {
    
  }
  createMedico(): void{
    this.medicoService.create(this.medico).subscribe(() => {
      this.medicoService.showMessage('Médico criado!')
      this.router.navigate(['/medicos'])
    })
  }
  cancelMedico(): void{
    this.router.navigate(['/medicos'])
  }

}
