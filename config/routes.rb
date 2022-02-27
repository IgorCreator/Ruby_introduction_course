Rails.application.routes.draw do
  resources :articles
  # resources :articles, only: [:show, :index, :new, :create, :edit, :update, :destroy]
  root 'pages#home'
  get 'about', to: 'pages#about'
  get 'about_mozilla', to: 'pages#about_mozilla'
end
