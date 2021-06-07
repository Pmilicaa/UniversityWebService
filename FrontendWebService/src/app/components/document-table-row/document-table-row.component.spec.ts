import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocumentTableRowComponent } from './document-table-row.component';

describe('DocumentTableRowComponent', () => {
  let component: DocumentTableRowComponent;
  let fixture: ComponentFixture<DocumentTableRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DocumentTableRowComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DocumentTableRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
