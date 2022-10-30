import { HttpClientTestingModule } from '@angular/common/http/testing';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterModule } from '@angular/router';
import { RouterTestingModule } from '@angular/router/testing';

import { UserPresentationPageComponent } from './user-presentation-page.component';

describe('UserPresentationPageComponent', () => {
  let component: UserPresentationPageComponent;
  let fixture: ComponentFixture<UserPresentationPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
        imports: [HttpClientTestingModule, RouterModule, RouterTestingModule],

      declarations: [ UserPresentationPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserPresentationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
