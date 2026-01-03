import { Routes } from '@angular/router';
import { AutorListaComponent } from './pages/autor-lista/autor-lista.component';
import { AutorFormComponent } from './pages/autor-form/autor-form.component';
import { CategoriaListaComponent } from './pages/categoria-lista/categoria-lista.component';
import { CategoriaFormComponent } from './pages/categoria-form/categoria-form.component';

export const routes: Routes = [
  { path: 'autores', component: AutorListaComponent },
  { path: 'autores/novo', component: AutorFormComponent },
  { path: 'autores/editar/:id', component: AutorFormComponent },
  { path: '', redirectTo: 'autores', pathMatch: 'full' }
];

