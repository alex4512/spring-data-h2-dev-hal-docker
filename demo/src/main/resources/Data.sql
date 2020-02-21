Insert into header (DOCID,DOCUMENT_NUMBER,NET_AMT,TOT_AMT,APPROVER)
values
(252,'Volvic1002',1.52, 1.60, 'MSC'),
(456,'Mc Cafe 001', 0.30, 0.50, 'AAR');
--LINE_NUM  	DESCRIPTION  	GL_ACCOUNT  	NET_AMT  	ORDER_NUM  	TOT_AMT  	DOCID  
Insert into body (DOCID, LINE_NUM,DESCRIPTION,GL_ACCOUNT,NET_AMT, TOT_AMT, ORDER_NUM)
values
(252,1,'Interesting Description','03-2215-05-000-000', '1.52','1.60', '50cl'),
(456,2,'Mc Cafe 001', '03-2215-03-000-000',0.30, 0.50, 'B12027314-19');


Insert into approvalmatrix (coder, amount, gl_code)
values
('MSC', 1000, '03-2215-05-000-000'),
('MSC', 0, '03-2215-15-000-000'),
('AAR', 0, '03-2215-05-000-000'),
('AAR', 10, '03-2215-03-000-000')