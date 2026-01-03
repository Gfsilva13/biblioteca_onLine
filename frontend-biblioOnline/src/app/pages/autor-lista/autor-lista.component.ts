import { Component, OnInit } from '@angular/core';
import { NgFor } from '@angular/common';
import { Router } from '@angular/router';
import { AutorResponse } from '../../models/autor.model';
import { AutorService } from '../../services/autor.service';

@Component({
  selector: 'app-autor-lista',
  standalone: true,
  imports: [NgFor],
  templateUrl: './autor-lista.component.html'
})
export class AutorListaComponent implements OnInit {

  autores: AutorResponse[] = [];
  page = 1;
  size = 10;

  constructor(private autorService: AutorService,
              private router: Router
  ) {}

  ngOnInit(): void {
    this.carregarAutores();
  }

  carregarAutores(): void {
    this.autorService.listar(this.page, this.size)
      .subscribe(response => this.autores = response);
  }

  editar(id: number): void {
    this.router.navigate(['/autores/editar', id]);
  }

  novo(): void {
    this.router.navigate(['/autores/novo']);
  }

  excluir(id: number): void {
    if (confirm('Deseja realmente excluir este autor?')) {
      this.autorService.excluir(id).subscribe(() => {
        this.carregarAutores();
      });
    }
  }

  voltar(): void {
    this.router.navigate(['/home']);
  }
}

