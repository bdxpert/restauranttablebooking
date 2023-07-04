"use strict";(self.webpackChunktable_booking_app=self.webpackChunktable_booking_app||[]).push([[41],{41:(J,a,d)=>{d.r(a),d.d(a,{OrderModule:()=>I});var u=d(6814),t=d(4946),m=d(9862),s=d(553);let c=(()=>{class o{constructor(){this.httpClient=(0,t.f3M)(m.eN)}addOrder(e){return this.httpClient.post(`${s.N.BaseAPIUrl}/transactions`,e)}deleteOrder(e){return this.httpClient.delete(`${s.N.BaseAPIUrl}/transactions/${e}`)}getOrderByCustomerId(e){return this.httpClient.get(`${s.N.BaseAPIUrl}/transactions/customer/${e}`)}getAllOrders(){return this.httpClient.get(`${s.N.BaseAPIUrl}/transactions`)}}return o.\u0275fac=function(e){return new(e||o)},o.\u0275prov=t.Yz7({token:o,factory:o.\u0275fac,providedIn:"root"}),o})();function g(o,n){if(1&o&&(t.TgZ(0,"tr")(1,"td"),t._uU(2),t.qZA(),t.TgZ(3,"td"),t._uU(4),t.qZA(),t.TgZ(5,"td"),t._uU(6),t.qZA(),t.TgZ(7,"td"),t._uU(8),t.qZA(),t.TgZ(9,"td"),t._uU(10),t.qZA(),t.TgZ(11,"td"),t._uU(12),t.qZA(),t.TgZ(13,"td"),t._uU(14),t.qZA(),t.TgZ(15,"td"),t._uU(16),t.qZA(),t.TgZ(17,"td"),t._uU(18),t.qZA(),t.TgZ(19,"td"),t._uU(20),t.qZA(),t.TgZ(21,"td"),t._uU(22),t.qZA(),t.TgZ(23,"td"),t._uU(24),t.qZA()()),2&o){const e=n.$implicit;t.xp6(2),t.Oqu(e.id),t.xp6(2),t.Oqu(e.date),t.xp6(2),t.Oqu(e.paidAmount),t.xp6(2),t.Oqu(e.dueAmount),t.xp6(2),t.Oqu(e.balance),t.xp6(2),t.Oqu(e.customer.name),t.xp6(2),t.Oqu(e.customer.phone),t.xp6(2),t.Oqu(e.customer.email),t.xp6(2),t.Oqu(e.booking.bdate),t.xp6(2),t.Oqu(e.booking.startTime),t.xp6(2),t.Oqu(e.booking.personCount),t.xp6(2),t.Oqu(e.booking.notes)}}let p=(()=>{class o{constructor(){this.orderService=(0,t.f3M)(c),this.orders=[],this.getAllOrders()}getAllOrders(){this.orderService.getAllOrders().subscribe(e=>{"OK"===e.status&&e.data&&(this.orders=e.data||[])})}}return o.\u0275fac=function(e){return new(e||o)},o.\u0275cmp=t.Xpm({type:o,selectors:[["app-list"]],decls:31,vars:1,consts:[[1,"order-table"],[4,"ngFor","ngForOf"]],template:function(e,r){1&e&&(t.TgZ(0,"h2"),t._uU(1,"Transaction List"),t.qZA(),t.TgZ(2,"table",0)(3,"thead")(4,"tr")(5,"th"),t._uU(6,"ID"),t.qZA(),t.TgZ(7,"th"),t._uU(8,"Date"),t.qZA(),t.TgZ(9,"th"),t._uU(10,"Paid Amount"),t.qZA(),t.TgZ(11,"th"),t._uU(12,"Due Amount"),t.qZA(),t.TgZ(13,"th"),t._uU(14,"Balance"),t.qZA(),t.TgZ(15,"th"),t._uU(16,"Customer Name"),t.qZA(),t.TgZ(17,"th"),t._uU(18,"Customer Phone"),t.qZA(),t.TgZ(19,"th"),t._uU(20,"Customer Email"),t.qZA(),t.TgZ(21,"th"),t._uU(22,"Booking Date"),t.qZA(),t.TgZ(23,"th"),t._uU(24,"Booking Time"),t.qZA(),t.TgZ(25,"th"),t._uU(26,"Person Count"),t.qZA(),t.TgZ(27,"th"),t._uU(28,"Notes"),t.qZA()()(),t.TgZ(29,"tbody"),t.YNc(30,g,25,12,"tr",1),t.qZA()()),2&e&&(t.xp6(30),t.Q6J("ngForOf",r.orders))},dependencies:[u.sg],styles:[".order-table[_ngcontent-%COMP%]{width:100%;border-collapse:collapse;margin-top:20px}.order-table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%], .order-table[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{border:1px solid #ccc;padding:8px;text-align:center}.order-table[_ngcontent-%COMP%]   th[_ngcontent-%COMP%]{background-color:#f2f2f2;font-weight:700}.order-table[_ngcontent-%COMP%]   tbody[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]:nth-child(even){background-color:#f2f2f2}.order-table[_ngcontent-%COMP%]   tbody[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]:hover{background-color:#e0e0e0}"]}),o})();var i=d(95),A=d(8010),_=d(314),l=d(4670);function Z(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Transaction Date is required."),t.qZA())}function f(o,n){if(1&o&&(t.TgZ(0,"div"),t.YNc(1,Z,2,0,"div",3),t.qZA()),2&o){const e=t.oxw();t.xp6(1),t.Q6J("ngIf",null==e.date.errors?null:e.date.errors.required)}}function v(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Paid Amount is required."),t.qZA())}function h(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Paid Amount must be greater than or equal to 0."),t.qZA())}function b(o,n){if(1&o&&(t.TgZ(0,"div"),t.YNc(1,v,2,0,"div",3),t.YNc(2,h,2,0,"div",3),t.qZA()),2&o){const e=t.oxw();t.xp6(1),t.Q6J("ngIf",null==e.paidAmount.errors?null:e.paidAmount.errors.required),t.xp6(1),t.Q6J("ngIf",null==e.paidAmount.errors?null:e.paidAmount.errors.min)}}function q(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Due Amount is required."),t.qZA())}function C(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Due Amount must be greater than or equal to 0."),t.qZA())}function T(o,n){if(1&o&&(t.TgZ(0,"div"),t.YNc(1,q,2,0,"div",3),t.YNc(2,C,2,0,"div",3),t.qZA()),2&o){const e=t.oxw();t.xp6(1),t.Q6J("ngIf",null==e.dueAmount.errors?null:e.dueAmount.errors.required),t.xp6(1),t.Q6J("ngIf",null==e.dueAmount.errors?null:e.dueAmount.errors.min)}}function O(o,n){if(1&o&&(t.TgZ(0,"option",16),t._uU(1),t.qZA()),2&o){const e=n.$implicit;t.Q6J("value",e.id),t.xp6(1),t.Oqu(e.name)}}function x(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Customer is required."),t.qZA())}function U(o,n){if(1&o&&(t.TgZ(0,"div"),t.YNc(1,x,2,0,"div",3),t.qZA()),2&o){const e=t.oxw();t.xp6(1),t.Q6J("ngIf",null==e.customer.errors?null:e.customer.errors.required)}}function k(o,n){if(1&o&&(t.TgZ(0,"option",16),t._uU(1),t.qZA()),2&o){const e=n.$implicit;t.Q6J("value",e.id),t.xp6(1),t.Oqu(e.bdate)}}function M(o,n){1&o&&(t.TgZ(0,"div"),t._uU(1,"Booking is required."),t.qZA())}function P(o,n){if(1&o&&(t.TgZ(0,"div"),t.YNc(1,M,2,0,"div",3),t.qZA()),2&o){const e=t.oxw();t.xp6(1),t.Q6J("ngIf",null==e.booking.errors?null:e.booking.errors.required)}}let N=(()=>{class o{constructor(){this.customerService=(0,t.f3M)(A.v),this.bookService=(0,t.f3M)(_.Z),this.orderService=(0,t.f3M)(c),this.router=(0,t.f3M)(l.F0),this.customers=[],this.bookings=[],this.orderForm=(0,t.f3M)(i.qu).nonNullable.group({date:[null,i.kI.required],paidAmount:[0,[i.kI.required,i.kI.min(0)]],dueAmount:[0,[i.kI.required,i.kI.min(0)]],balance:[0,[i.kI.required,i.kI.min(0)]],customer:["",[i.kI.required]],booking:["",[i.kI.required]],notes:[""]}),this.getAllCustomer()}get date(){return this.orderForm.get("date")}get paidAmount(){return this.orderForm.get("paidAmount")}get dueAmount(){return this.orderForm.get("dueAmount")}get balance(){return this.orderForm.get("balance")}get notes(){return this.orderForm.get("notes")}get customer(){return this.orderForm.get("customer")}get booking(){return this.orderForm.get("booking")}getAllCustomer(){this.customerService.getAllCustomers().subscribe(e=>{e&&"OK"===e.status&&(this.customers=e.data)})}getAvailableBookingByCustomer(){this.bookService.getAllBookingsByCustomer(this.customer.value).subscribe(r=>{r&&"OK"===r.status&&(this.bookings=r.data)})}onReserveHandler(){const e={date:this.date.value,paidAmount:this.paidAmount.value,dueAmount:this.dueAmount.value,balance:this.dueAmount.value-this.paidAmount.value,notes:this.notes.value,customer:{id:Number(this.customer.value),name:"",phone:"",email:""},booking:{id:Number(this.booking.value),bdate:"",startTime:"",personCount:0,notes:""}};this.orderService.addOrder(e).subscribe(r=>{r&&"OK"===r.status&&(this.orderForm.reset(),console.log("Order information saved successfully"),this.router.navigate(["","order","list"]))})}}return o.\u0275fac=function(e){return new(e||o)},o.\u0275cmp=t.Xpm({type:o,selectors:[["app-add"]],decls:40,vars:8,consts:[[3,"formGroup","submit"],["for","orderDate"],["type","date","id","orderDate","formControlName","date"],[4,"ngIf"],["for","paidAmount"],["type","number","id","paidAmount","formControlName","paidAmount"],["for","dueAmount"],["type","number","id","dueAmount","formControlName","dueAmount"],["for","customer"],["id","customer","formControlName","customer",3,"change"],["value",""],[3,"value",4,"ngFor","ngForOf"],["for","booking"],["id","booking","formControlName","booking"],["for","notes"],["id","notes","formControlName","notes"],[3,"value"]],template:function(e,r){1&e&&(t.TgZ(0,"h2"),t._uU(1,"Add Transaction"),t.qZA(),t.TgZ(2,"form",0),t.NdJ("submit",function(){return r.onReserveHandler()}),t.TgZ(3,"div")(4,"label",1),t._uU(5,"Transaction Date"),t.qZA(),t._UZ(6,"input",2),t.YNc(7,f,2,1,"div",3),t.qZA(),t.TgZ(8,"div")(9,"label",4),t._uU(10,"Paid Amount"),t.qZA(),t._UZ(11,"input",5),t.YNc(12,b,3,2,"div",3),t.qZA(),t.TgZ(13,"div")(14,"label",6),t._uU(15,"Due Amount"),t.qZA(),t._UZ(16,"input",7),t.YNc(17,T,3,2,"div",3),t.qZA(),t.TgZ(18,"div")(19,"label",8),t._uU(20,"Customer"),t.qZA(),t.TgZ(21,"select",9),t.NdJ("change",function(){return r.getAvailableBookingByCustomer()}),t.TgZ(22,"option",10),t._uU(23,"Select a customer"),t.qZA(),t.YNc(24,O,2,2,"option",11),t.qZA(),t.YNc(25,U,2,1,"div",3),t.qZA(),t.TgZ(26,"div")(27,"label",12),t._uU(28,"Booking"),t.qZA(),t.TgZ(29,"select",13)(30,"option",10),t._uU(31,"Select a booking"),t.qZA(),t.YNc(32,k,2,2,"option",11),t.qZA(),t.YNc(33,P,2,1,"div",3),t.qZA(),t.TgZ(34,"div")(35,"label",14),t._uU(36,"Notes"),t.qZA(),t._UZ(37,"textarea",15),t.qZA(),t.TgZ(38,"button"),t._uU(39,"Submit"),t.qZA()()),2&e&&(t.xp6(2),t.Q6J("formGroup",r.orderForm),t.xp6(5),t.Q6J("ngIf",r.date.invalid&&r.date.touched),t.xp6(5),t.Q6J("ngIf",r.paidAmount.invalid&&r.paidAmount.touched),t.xp6(5),t.Q6J("ngIf",r.dueAmount.invalid&&r.dueAmount.touched),t.xp6(7),t.Q6J("ngForOf",r.customers),t.xp6(1),t.Q6J("ngIf",r.customer.invalid&&r.customer.touched),t.xp6(7),t.Q6J("ngForOf",r.bookings),t.xp6(1),t.Q6J("ngIf",r.booking.invalid&&r.booking.touched))},dependencies:[u.sg,u.O5,i._Y,i.YN,i.Kr,i.Fj,i.wV,i.EJ,i.JJ,i.JL,i.sg,i.u],styles:["h2[_ngcontent-%COMP%]{text-align:center;color:#333}form[_ngcontent-%COMP%]{max-width:400px;margin:0 auto;padding:20px;border:1px solid #ccc;border-radius:5px}form[_ngcontent-%COMP%]   div[_ngcontent-%COMP%]{margin-bottom:15px}label[_ngcontent-%COMP%]{display:block;font-weight:700;margin-bottom:5px}input[type=date][_ngcontent-%COMP%], input[type=time][_ngcontent-%COMP%], input[type=number][_ngcontent-%COMP%], select[_ngcontent-%COMP%], textarea[_ngcontent-%COMP%]{width:100%;padding:10px;border:1px solid #ccc;border-radius:5px}select[multiple][_ngcontent-%COMP%]{height:120px}div.error[_ngcontent-%COMP%]{color:#dc3545;margin-top:5px}button[_ngcontent-%COMP%]{display:block;width:100%;padding:10px;background-color:#007bff;color:#fff;border:none;border-radius:5px;cursor:pointer;font-size:16px}button[_ngcontent-%COMP%]:hover{background-color:#0056b3}"]}),o})(),I=(()=>{class o{}return o.\u0275fac=function(e){return new(e||o)},o.\u0275mod=t.oAB({type:o}),o.\u0275inj=t.cJS({imports:[u.ez,i.UX,l.Bz.forChild([{path:"list",component:p},{path:"add",component:N}])]}),o})()}}]);