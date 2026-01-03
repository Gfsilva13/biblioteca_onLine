import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { AutorService } from '../../services/autor.service';
import { AutorRequest } from '../../models/autor.model';

@Component({
  selector: 'app-autor-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './autor-form.component.html'
})
export class AutorFormComponent implements OnInit {

  form!: FormGroup;
  id?: number;
  edicao = false;

  constructor(
    private fb: FormBuilder,
    private service: AutorService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.form = this.fb.group({
      nomeAutor: ['', Validators.required]
    });

    this.id = Number(this.route.snapshot.paramMap.get('id'));

    if (this.id) {
      this.edicao = true;
      this.service.buscarPorId(this.id).subscribe({
        next: (autor) => this.form.patchValue({nomeAutor: autor.nomeAutor}),
        error: () => alert
      });
    }
  }

  salvar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const autor: AutorRequest = this.form.value;

    if (this.edicao) {
      this.service.atualizar(this.id!, autor).subscribe(() => {
        alert('Autor atualizado com sucesso!');
        this.voltar();
      });
    } else {
      this.service.cadastrar(autor).subscribe(() => {
        alert('Autor cadastrado com sucesso!');
        this.voltar();
      });
    }
  }

  voltar(): void {
    this.router.navigate(['/autores']);
  }
}
