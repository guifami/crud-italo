import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Medico } from '../medico.model';
import { MedicoService } from '../medico.service';

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {

  medico!: Medico

  constructor(private medicoService: MedicoService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    
    const idParam = this.route.snapshot.paramMap.get('id');
    const id = idParam ? +idParam : null;
    if(id != null)
    {
      this.medicoService.readByID(id).subscribe(medico =>{
        this.medico = medico
      })
    }
  }

  deleteMedico(): void{
    this.medicoService.delete(this.medico.idMedico).subscribe(medico =>{
      this.medicoService.showMessage('Médico excluido com sucesso!')
      this.router.navigate(['/medicos'])
    })
  }

  cancel(): void{
    this.router.navigate(['/medicos'])
  }

}
