import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Medico } from '../medico.model';
import { MedicoService } from '../medico.service';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {

  medico!: Medico;

  constructor(
    private medicoService: MedicoService,
    private router: Router,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    const idParam = this.route.snapshot.paramMap.get('id');
    const id = idParam ? +idParam : null;
    if(id != null) {
      this.medicoService.readByID(id).subscribe(medico => {
        this.medico = medico;
      });
    }
  }

  updateMedico(): void {
    const updatedLimite = this.medico.limite;
    this.medicoService.update(this.medico.idMedico, updatedLimite).subscribe(() => {
      this.medicoService.showMessage('Médico atualizado com sucesso!');
      this.router.navigate(['/medicos']);
    });
  }

  cancel(): void {
    this.router.navigate(['/medicos']);
  }
}
