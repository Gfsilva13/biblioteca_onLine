import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoriaService } from '../../services/categoria.service';
import { CategoriaRequest } from '../../models/categoria.model';

@Component({
  selector: 'app-categoria-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './categoria-form.component.html'
})
export class CategoriaFormComponent implements OnInit {

  form!: FormGroup;
  id?: number;
  edicao = false;

  constructor(
    private fb: FormBuilder,
    private service: CategoriaService,
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
        next: (categoria) => this.form.patchValue({catgoria: categoria.categoria}),
        error: () => alert
      });
    }
  }

  salvar(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }

    const categoria: CategoriaRequest = this.form.value;

    if (this.edicao) {
      this.service.atualizar(this.id!, categoria).subscribe(() => {
        alert('Categoria atualizada com sucesso!');
        this.voltar();
      });
    } else {
      this.service.cadastrar(categoria).subscribe(() => {
        alert('Categoria cadastrada com sucesso!');
        this.voltar();
      });
    }
  }

  voltar(): void {
    this.router.navigate(['/categorias']);
  }
}
