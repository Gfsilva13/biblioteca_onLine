import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';
import { Router } from '@angular/router';
import { CategoriaResponse } from '../../models/categoria.model';
import { CategoriaService } from '../../services/categoria.service';

@Component({
  selector: 'app-categoria-lista',
  standalone: true,
  imports: [NgFor],
  templateUrl: './categoria-lista.component.html'
})
export class CategoriaListaComponent implements OnInit {

  categorias: CategoriaResponse[] = [];
  page = 1;
  size = 10;

  constructor(private categoriaService: CategoriaService,
              private router: Router
  ) {}

  ngOnInit(): void {
    this.carregarCategorias();
  }

  carregarCategorias(): void {
    this.categoriaService.listar(this.page, this.size)
      .subscribe(response => this.categorias = response);
  }

  editar(id: number): void {
    this.router.navigate(['/categorias/editar', id]);
  }

  novo(): void {
    this.router.navigate(['/categorias/novo']);
  }

  excluir(id: number): void {
    if (confirm('Deseja realmente excluir esta categoria?')) {
      this.categoriaService.excluir(id).subscribe(() => {
        this.carregarCategorias();
      });
    }
  }
}


