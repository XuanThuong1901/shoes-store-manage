create trigger thaydoittdonhang 
on donhang
after insert, update
as
begin
	declare @trangthai int
	declare @manv varchar(15)

	select @trangthai = inserted.TinhTrangDonHang, @manv = inserted.MaNV from inserted
	if(@manv is null and @trangthai != 1)
	begin
		rollback tran
	end

	if(@manv is not null and @trangthai = 1)
	begin
		rollback tran
	end

end

